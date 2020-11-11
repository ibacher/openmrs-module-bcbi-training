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

import static org.openmrs.module.bcbitraining.BCBITrainingConstants.ADMISSION_ENCOUNTER_TYPE_UUID;
import static org.openmrs.module.bcbitraining.BCBITrainingConstants.HOSPITAL_LOCATION_UUID;
import static org.openmrs.module.bcbitraining.BCBITrainingConstants.MIREBALAIS_VISIT_TYPE_UUID;
import static org.openmrs.module.bcbitraining.BCBITrainingConstants.PHYSICIAN_PROVIDERROLE_UUID;
import static org.openmrs.module.bcbitraining.BCBITrainingConstants.REGISTRATION_ENCOUNTER_TYPE_UUID;
import static org.openmrs.module.bcbitraining.BCBITrainingConstants.ZL_EMR_PATIENT_ID_TYPE_UUID;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.csv.CSVRecord;
import org.openmrs.Concept;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifierType;
import org.openmrs.api.ConceptService;
import org.openmrs.api.PatientService;
import org.openmrs.module.bcbitraining.descriptor.data.DiagnosisDescriptor;
import org.openmrs.module.emrapi.encounter.domain.EncounterTransaction;
import org.openmrs.module.providermanagement.Provider;
import org.openmrs.module.providermanagement.ProviderRole;
import org.openmrs.module.providermanagement.api.ProviderManagementService;

public class PatientRegistrationHandler extends BaseCSVHandler {

	private static final String DATA_FILE = "/data/registration_encounters.csv";

	private static final String DX_DATA_FILE = "/data/diagnoses.csv";

	public Iterable<EncounterTransaction> generateRegistrationEncounters(ConceptService conceptService,
			PatientService patientService, ProviderManagementService providerManagementService) throws IOException {
		Set<EncounterTransaction> encounters = new LinkedHashSet<>();
		PatientIdentifierType identifierType = patientService.getPatientIdentifierTypeByUuid(ZL_EMR_PATIENT_ID_TYPE_UUID);
		ProviderRole physicianRole = providerManagementService.getProviderRoleByUuid(PHYSICIAN_PROVIDERROLE_UUID);

		Concept birthplace = conceptService.getConceptByMapping("Birthplace address construct", "PIH");
		Concept country = conceptService.getConceptByMapping("Country", "PIH");
		Concept cityVillage = conceptService.getConceptByMapping("City Village", "PIH");
		Concept stateProvince = conceptService.getConceptByMapping("State Province", "PIH");
		Concept address3 = conceptService.getConceptByMapping("Address3", "PIH");
		Concept address1 = conceptService.getConceptByMapping("Address1", "PIH");

		Concept civilStatus = conceptService.getConceptByMapping("CIVIL STATUS", "PIH");
		Map<String, Concept> civilStatusConcepts = new LinkedHashMap<>();
		civilStatusConcepts.put("SINGLE", conceptService.getConceptByMapping("SINGLE OR A CHILD", "PIH"));
		civilStatusConcepts.put("MARRIED", conceptService.getConceptByMapping("MARRIED", "PIH"));
		civilStatusConcepts.put("DIVORCED", conceptService.getConceptByMapping("DIVORCED", "PIH"));
		civilStatusConcepts.put("WIDOWED", conceptService.getConceptByMapping("WIDOWED", "PIH"));
		civilStatusConcepts.put("SEPARATED", conceptService.getConceptByMapping("SEPARATED", "PIH"));
		civilStatusConcepts.put("UNKNOWN (DEFAULT)", conceptService.getConceptByMapping("unknown", "PIH"));
		civilStatusConcepts.put("", conceptService.getConceptByMapping("unknown", "PIH"));
		civilStatusConcepts.put(null, conceptService.getConceptByMapping("unknown", "PIH"));

		Concept religion = conceptService.getConceptByMapping("Religion", "PIH");
		Map<String, Concept> religionConcepts = new LinkedHashMap<>();
		religionConcepts.put("CATHOLIC", conceptService.getConceptByMapping("Catholic", "PIH"));
		religionConcepts.put("OTHER", conceptService.getConceptByMapping("OTHER", "PIH"));
		religionConcepts.put("PROTESTANT QUAKER", conceptService.getConceptByMapping("163125", "CIEL"));
		religionConcepts.put("CHRISTIAN SCIENTIST", conceptService.getConceptByMapping("163125", "CIEL"));
		religionConcepts.put("JEWISH", conceptService.getConceptByMapping("OTHER", "PIH"));
		religionConcepts.put("UNOBTAINABLE", conceptService.getConceptByMapping("OTHER", "PIH"));
		religionConcepts.put("NOT SPECIFIED", conceptService.getConceptByMapping("OTHER", "PIH"));
		religionConcepts.put("BUDDHIST", conceptService.getConceptByMapping("OTHER", "PIH"));
		religionConcepts.put("ROMANIAN EAST. ORTH", conceptService.getConceptByMapping("163125", "CIEL"));
		religionConcepts.put("MUSLIM", conceptService.getConceptByMapping("Islam", "PIH"));
		religionConcepts.put("", conceptService.getConceptByMapping("OTHER", "PIH"));
		religionConcepts.put(null, conceptService.getConceptByMapping("OTHER", "PIH"));

		Concept occupation = conceptService.getConceptByMapping("Occupation", "PIH");
		Concept otherOccupation = conceptService.getConceptByMapping("OTHER", "PIH");

		Concept visitDiagnoses = conceptService.getConceptByMapping("Visit Diagnoses", "PIH");
		Concept diagnosisConcept = conceptService.getConceptByMapping("DIAGNOSIS", "PIH");
		Concept diagnosisCertainty = conceptService.getConceptByMapping("1379", "PIH");
		Concept diagnosisOrder = conceptService.getConceptByMapping("Diagnosis order", "PIH");
		Concept primary = conceptService.getConceptByMapping("primary", "PIH");
		Concept secondary = conceptService.getConceptByMapping("secondary", "PIH");
		Concept confirmed = conceptService.getConceptByMapping("CONFIRMED", "PIH");

		List<Provider> physicians = providerManagementService.getProvidersByRoles(Collections.singletonList(physicianRole));

		Map<String, Collection<DiagnosisDescriptor>> diagnoses = new LinkedHashMap<>();
		for (CSVRecord record : getRecordsForFile(DX_DATA_FILE)) {
			String patientId = record.get("SUBJECT_ID");
			Collection<DiagnosisDescriptor> patientDxs = diagnoses.computeIfAbsent(patientId, k -> new ArrayList<>());
			final String cielCode = record.get("CIEL_CODE");
			final boolean primaryDx = record.get("PRIMARY_DX").equals("1");

			patientDxs.add(new DiagnosisDescriptor() {

				@Override
				public String cielCode() {
					return cielCode;
				}

				@Override
				public boolean primary() {
					return primaryDx;
				}
			});
		}

		Date now = new Date();

		int physician = 0;
		boolean hasRecords = false;
		for (CSVRecord record : getRecordsForFile(DATA_FILE)) {
			hasRecords = true;
			Patient patient = getPatientForRecord(record, patientService, identifierType);
			if (patient == null) {
				continue;
			}

			Date encounterDate;
			try {
				encounterDate = DATE_FORMAT.parse(record.get("ADMITTIME"));
			}
			catch (ParseException e) {
				throw new IOException(e);
			}

			if (encounterDate.after(now)) {
				encounterDate = now;
			}

			Set<EncounterTransaction.Provider> providers = new LinkedHashSet<>(
					Collections.singletonList(getProviderFromPhysician(physicians.get(physician))));

			// calculate next physician
			physician = (physician + 1) % physicians.size();

			EncounterTransaction encounter = createEncounter(
					REGISTRATION_ENCOUNTER_TYPE_UUID, encounterDate, providers, patient.getUuid());

			encounter.addObservation(
					getPlaceOfBirth(birthplace, country, cityVillage, stateProvince, address3, address1, encounterDate));

			addObsIfNotNull(encounter, createObsForConcept(occupation, encounterDate, otherOccupation.getUuid()));
			addObsIfNotNull(encounter, createObsForConcept(civilStatus, encounterDate,
					civilStatusConcepts.get(record.get("MARITAL_STATUS")).getUuid()));
			addObsIfNotNull(encounter, createObsForConcept(religion, encounterDate,
					religionConcepts.get(record.get("RELIGION")).getUuid()));

			encounters.add(encounter);

			EncounterTransaction admission = createEncounter(
					ADMISSION_ENCOUNTER_TYPE_UUID, encounterDate, providers, patient.getUuid());

			for (DiagnosisDescriptor descriptor : diagnoses
					.getOrDefault(patient.getPatientIdentifier(identifierType).getIdentifier(), new LinkedHashSet<>())) {
				Concept diagnosis = conceptService.getConceptByMapping(descriptor.cielCode(), "CIEL");
				if (diagnosis == null) {
					continue;
				}

				EncounterTransaction.Observation observationGroup = createObsForConcept(visitDiagnoses, encounterDate, null);
				addObsIfNotNull(observationGroup,
						createObsForConcept(diagnosisConcept, encounterDate, diagnosis.getUuid()));
				addObsIfNotNull(observationGroup,
						createObsForConcept(diagnosisCertainty, encounterDate, confirmed.getUuid()));
				addObsIfNotNull(observationGroup,
						createObsForConcept(diagnosisOrder, encounterDate,
								descriptor.primary() ? primary.getUuid() : secondary.getUuid()));
				admission.addObservation(observationGroup);
			}

			encounters.add(admission);
		}

		if (hasRecords) {
			saveDataRecord(DATA_FILE);
		}

		return encounters;
	}

	private EncounterTransaction createEncounter(String encounterTypeUuid, Date encounterDate,
			Set<EncounterTransaction.Provider> providers, String patientUuid) {
		EncounterTransaction encounter = new EncounterTransaction()
				.setEncounterDateTime(encounterDate)
				.setEncounterTypeUuid(encounterTypeUuid)
				.setLocationUuid(HOSPITAL_LOCATION_UUID)
				.setVisitTypeUuid(MIREBALAIS_VISIT_TYPE_UUID)
				.setPatientUuid(patientUuid);

		// gotta love API consistency
		encounter.setVisitLocationUuid(HOSPITAL_LOCATION_UUID);
		encounter.setProviders(providers);

		return encounter;
	}

	private EncounterTransaction.Observation getPlaceOfBirth(Concept birthplace, Concept country, Concept cityVillage,
			Concept stateProvince, Concept address3, Concept address1, Date observationDate) {
		EncounterTransaction.Observation birthplaceObs = createObsForConcept(birthplace, observationDate, null);

		birthplaceObs.addGroupMember(createObsForConcept(country, observationDate, "Yon lot peyi"));
		birthplaceObs.addGroupMember(createObsForConcept(cityVillage, observationDate, "-"));
		birthplaceObs.addGroupMember(createObsForConcept(stateProvince, observationDate, "-"));
		birthplaceObs.addGroupMember(createObsForConcept(address3, observationDate, "-"));
		birthplaceObs.addGroupMember(createObsForConcept(address1, observationDate, "Yon lot"));

		return birthplaceObs;
	}

}
