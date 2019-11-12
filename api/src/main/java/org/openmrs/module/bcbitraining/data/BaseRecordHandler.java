/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.bcbitraining.data;

import static org.openmrs.module.bcbitraining.BCBITrainingConstants.CONSULTING_PHYSICIAN_UUID;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;
import org.openmrs.Concept;
import org.openmrs.ConceptNumeric;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifierType;
import org.openmrs.api.PatientService;
import org.openmrs.api.context.Context;
import org.openmrs.module.bcbitraining.BCBIDataRecord;
import org.openmrs.module.bcbitraining.api.BCBIDataRecordService;
import org.openmrs.module.emrapi.encounter.domain.EncounterTransaction;
import org.openmrs.module.providermanagement.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseRecordHandler {

	final Logger log = LoggerFactory.getLogger("org.openmrs.api");
	static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	Iterable<CSVRecord> getRecordsForFile(String file) throws IOException {
		if (file == null) {
			throw new IllegalArgumentException("file cannot be null");
		}

		InputStream is = this.getClass().getResourceAsStream(file);
		if (is == null) {
			log.error("Could not find file {}", file);
			return Collections.emptyList();
		}

		BCBIDataRecordService dataRecordService = Context.getService(BCBIDataRecordService.class);
		BCBIDataRecord dataRecord = dataRecordService.getDataRecordByFile(file);

		// mark the start of the input stream
		is.mark(Integer.MAX_VALUE);
		byte[] currentHash = DigestUtils.sha256(is);
		// rewind to actually read the input stream
		is.reset();

		if (dataRecord != null && hasFileBeenSeen(dataRecord, currentHash)) {
			log.info("File {} has already been processed", file);
			return Collections.emptyList();
		}

		return CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new InputStreamReader(new BOMInputStream(is))).getRecords();
	}

	void saveDataRecord(String file) throws IOException {
		InputStream is = this.getClass().getResourceAsStream(file);
		byte[] currentHash = DigestUtils.sha256(is);

		BCBIDataRecordService dataRecordService = Context.getService(BCBIDataRecordService.class);
		BCBIDataRecord dataRecord = dataRecordService.getDataRecordByFile(file);

		if (dataRecord == null) {
			dataRecord = new BCBIDataRecord();
			dataRecord.setFile(file);
		}

		dataRecord.setHashValue(currentHash);

		dataRecordService.saveDataRecord(dataRecord);
	}

	Patient getPatientForRecord(CSVRecord record, PatientService patientService, PatientIdentifierType identifierType) {
		String patientId = record.get("SUBJECT_ID");

		if (patientId == null || patientId.length() == 0) {
			log.info("Error: no SUBJECT_ID provided");
			return null;
		}

		List<Patient> patients = patientService.getPatients(null, patientId, Collections.singletonList(identifierType), true);

		if (patients.size() == 0 || patients.get(0) == null) {
			log.info("Could not find patient corresponding to id {}", patientId);
			return null;
		}

		return patients.get(0);
	}

	private boolean hasFileBeenSeen(BCBIDataRecord dataRecord, byte[] currentHash) {
		byte[] hashValue = dataRecord.getHashValue();
		if (hashValue == null) { return false; }
		return Arrays.equals(currentHash, hashValue);
	}

	EncounterTransaction.Provider getProviderFromPhysician(Provider provider) {
		EncounterTransaction.Provider etProvider = new EncounterTransaction.Provider();
		etProvider.setUuid(provider.getUuid());
		etProvider.setEncounterRoleUuid(CONSULTING_PHYSICIAN_UUID);
		return etProvider;
	}

	EncounterTransaction.Observation createObsForConcept(Concept concept, Date observationDate, Object value) {
		EncounterTransaction.Concept etConcept = new EncounterTransaction.Concept();
		etConcept.setUuid(concept.getUuid());
		etConcept.setConceptClass(concept.getConceptClass().getUuid());
		etConcept.setDataType(concept.getDatatype().getUuid());

		if (value != null) {
			if (concept.getDatatype().isNumeric()) {
				ConceptNumeric numericConcept = Context.getConceptService().getConceptNumericByUuid(concept.getUuid());

				if (value instanceof Number) {
					if (!valueInRange((Number) value, numericConcept)) {
						log.error("Value {} is not in range for concept {}", value, concept.getName());
						value = null;
					}
				}
				else if (value instanceof String) {
					if (numericConcept.getAllowDecimal()) {
						try {
							value = Double.parseDouble((String) value);
						}
						catch (NumberFormatException e) {
							value = null;
						}
					} else {
						try {
							value = Integer.parseInt((String) value);
						}
						catch (NumberFormatException e) {
							value = null;
						}
					}

					if (value != null) {
						if (!valueInRange((Number) value, numericConcept)) {
							log.error("Value {} is not in range for concept {}", value, concept.getName());
							value = null;
						}
					}

					if (value == null) {
						return null;
					}
				}
			}
		}

		return new EncounterTransaction.Observation()
				.setConcept(etConcept)
				.setObservationDateTime(observationDate)
				.setValue(value);
	}

	EncounterTransaction addObsIfNotNull(EncounterTransaction encounterTransaction, EncounterTransaction.Observation obs) {
		if (encounterTransaction == null) {
			throw new IllegalArgumentException("Encounter transaction cannot be null");
		}

		if (obs != null) {
			encounterTransaction.addObservation(obs);
		}

		return encounterTransaction;
	}

	EncounterTransaction.Observation addObsIfNotNull(EncounterTransaction.Observation observationGroup, EncounterTransaction.Observation obs) {
		if (observationGroup == null) {
			throw new IllegalArgumentException("Observation group cannot be null");
		}

		if (obs != null) {
			observationGroup.addGroupMember(obs);
		}

		return observationGroup;
	}

	private boolean valueInRange(Number value, ConceptNumeric numericConcept) {
		return valueInRange(value, numericConcept.getLowAbsolute(), numericConcept.getHiAbsolute());
	}

	private boolean valueInRange(Number value, Double lowValue, Double highValue) {
		double valueDouble = value.doubleValue();
		return !(valueDouble < lowValue) && !(valueDouble > highValue);
	}

}
