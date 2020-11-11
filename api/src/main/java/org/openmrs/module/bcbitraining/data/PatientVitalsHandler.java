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

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import org.apache.commons.csv.CSVRecord;
import org.openmrs.*;
import org.openmrs.api.ConceptService;
import org.openmrs.api.PatientService;
import org.openmrs.api.VisitService;
import org.openmrs.module.emrapi.encounter.domain.EncounterTransaction;
import org.openmrs.module.providermanagement.Provider;
import org.openmrs.module.providermanagement.ProviderRole;
import org.openmrs.module.providermanagement.api.ProviderManagementService;

import static org.openmrs.module.bcbitraining.BCBITrainingConstants.*;

public class PatientVitalsHandler extends BaseCSVHandler {

	private static final String DATA_FILE = "/data/vitals_encounters.csv";
	private static final String[] VITALS = { "HEIGHT", "WEIGHT", "TEMPERATURE", "HEART_RATE", "RESPIRATORY_RATE", "SYSTOLIC_BP", "DIASTOLIC_BP", "O2_SAT" };

	public Iterable<EncounterTransaction> generateVitalsEncounters(ConceptService conceptService, PatientService patientService, ProviderManagementService providerManagementService, VisitService visitService) throws IOException {
		Set<EncounterTransaction> encounters = new LinkedHashSet<>();
		PatientIdentifierType identifierType = patientService.getPatientIdentifierTypeByUuid(ZL_EMR_PATIENT_ID_TYPE_UUID);
		ProviderRole physicianRole = providerManagementService.getProviderRoleByUuid(PHYSICIAN_PROVIDERROLE_UUID);
		VisitType visitType = visitService.getVisitTypeByUuid(MIREBALAIS_VISIT_TYPE_UUID);

		Concept[] vitalConcepts = {
				conceptService.getConceptByMapping("HEIGHT (CM)", "PIH"),
				conceptService.getConceptByMapping("WEIGHT (KG)", "PIH"),
				conceptService.getConceptByMapping("TEMPERATURE (C)", "PIH"),
				conceptService.getConceptByMapping("PULSE", "PIH"),
				conceptService.getConceptByMapping("RESPIRATORY RATE", "PIH"),
				conceptService.getConceptByMapping("SYSTOLIC BLOOD PRESSURE", "PIH"),
				conceptService.getConceptByMapping("DIASTOLIC BLOOD PRESSURE", "PIH"),
				conceptService.getConceptByMapping("BLOOD OXYGEN SATURATION", "PIH")
		};

		List<Provider> physicians = providerManagementService.getProvidersByRoles(Collections.singletonList(physicianRole));

		int physician = 0;
		boolean hasRecords = false;
		for (CSVRecord record : getRecordsForFile(DATA_FILE)) {
			hasRecords = true;

			final Patient thePatient = getPatientForRecord(record, patientService, identifierType);
			if (thePatient == null) {
				continue;
			}

			Date encounterDate;
			try {
				encounterDate = DATE_FORMAT.parse(record.get("EVENT_TIME"));
			} catch (ParseException e) {
				throw new IOException(e);
			}

			String visitUuid = null;
			Set<EncounterTransaction.Provider> providers = null;
			List<Visit> visits = visitService.getVisits(Collections.singletonList(visitType), Collections.singletonList(thePatient),
					null, null, null, null, null,
					null, null, true, false);
			if (visits != null && visits.size() > 0 && visits.get(0) != null) {
				Visit visit = visits.get(0);
				if (visit.getStartDatetime().before(encounterDate) || visit.getStartDatetime().equals(encounterDate)) {
					if (visit.getStopDatetime() != null) {
						visit.setStopDatetime(null);
						visit = visitService.saveVisit(visit);
					}

					if (visit.getStartDatetime().before(encounterDate)) {
						encounterDate = visit.getStartDatetime();
					}


					visitUuid = visit.getUuid();

					Encounter registrationEncounter =  visit.getNonVoidedEncounters().get(0);
					for (EncounterProvider enProvider : registrationEncounter.getEncounterProviders()) {
						if (providers == null) {
							providers = new LinkedHashSet<>();
						}

						Provider provider = null;
						for (Provider provider1 : providerManagementService
								.getProvidersByPerson(enProvider.getProvider().getPerson(), false)) {
							if (provider1.getProviderRole().equals(physicianRole)) {
								provider = provider1;
								break;
							}
						}

						if (provider != null) {
							EncounterTransaction.Provider etProvider = new EncounterTransaction.Provider();
							etProvider.setUuid(provider.getUuid());
							etProvider.setEncounterRoleUuid(CONSULTING_PHYSICIAN_UUID);

							providers.add(etProvider);
						}
					}
				}
			} else {
				log.info("Could not find active visit for patient {}", thePatient.getPersonName());
			}

			EncounterTransaction encounter = new EncounterTransaction();
			encounter.setEncounterDateTime(encounterDate);
			encounter.setPatientUuid(thePatient.getUuid());
			encounter.setEncounterUuid(UUID.randomUUID().toString());
			encounter.setEncounterTypeUuid(VITALS_ENCOUNTER_TYPE_UUID);
			encounter.setLocationUuid(HOSPITAL_LOCATION_UUID);
			if (visitUuid != null) {
				encounter.setVisitUuid(visitUuid);
			} else {
				encounter.setVisitTypeUuid(MIREBALAIS_VISIT_TYPE_UUID);
				encounter.setVisitLocationUuid(HOSPITAL_LOCATION_UUID);
			}

			if (providers != null) {
				encounter.setProviders(providers);
			} else {
				encounter.setProviders(new LinkedHashSet<>(
						Collections.singletonList(getProviderFromPhysician(physicians.get(physician)))));
				physician = (physician + 1) % physicians.size();
			}

			for (int i = 0; i < VITALS.length; i++) {
				String vital = record.get(VITALS[i]);

				if (vital != null && !vital.equals("")) {
					addObsIfNotNull(encounter, createObsForConcept(vitalConcepts[i], encounterDate, vital));
				}
			}

			encounters.add(encounter);
		}

		if (hasRecords) {
			saveDataRecord(DATA_FILE);
		}

		return encounters;
	}

}
