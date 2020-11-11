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
import org.openmrs.api.PatientService;
import org.openmrs.api.PersonService;

import static org.openmrs.module.bcbitraining.BCBITrainingConstants.ZL_EMR_PATIENT_ID_TYPE_UUID;

public class PatientRecordHandler extends BaseCSVHandler {

	private static final String DATA_FILE = "/data/patients.csv";

	// Mirebalais divides addresses into specific Haiti addresses an "Yon lot peyi" -- Foreign country
	// for simplicity, all our patients are born and live in a foreign country.
	// this needs to be a function because each PersonAddress belongs to a single person.
	private static PersonAddress getDefaultAddress() {
		PersonAddress address = new PersonAddress();
		address.setAddress1("Yon lot");
		address.setAddress3("-");
		address.setCityVillage("-");
		address.setStateProvince("-");
		address.setCountry("Yon lot peyi");
		address.setPreferred(true);
		return address;
	}

	public Iterable<Patient> generatePatients(PatientService patientService, PersonService personService, Location defaultLocation) throws IOException {
		PatientIdentifierType identifierType = patientService.getPatientIdentifierTypeByUuid(ZL_EMR_PATIENT_ID_TYPE_UUID);

		// unfortunately, PIH has elected to store the mother's first name as the "race" attribute
		PersonAttributeType mothersFirstNameAttributeType = personService.getPersonAttributeTypeByName("Race");

		Set<Patient> patients = new LinkedHashSet<>();

		boolean hasRecords = false;
		for (CSVRecord record : getRecordsForFile(DATA_FILE)) {
			hasRecords = true;
			Patient patient = getPatientForRecord(record, patientService, identifierType);

		 	if (patient != null) {
		        setupPatient(patient, record, identifierType, defaultLocation, mothersFirstNameAttributeType);
			    patients.add(patient);
		    } else {
		 		patient = new Patient();
			    setupPatient(patient, record, identifierType, defaultLocation, mothersFirstNameAttributeType);
			    patients.add(patient);
		    }
		}

		if (hasRecords) {
			saveDataRecord(DATA_FILE);
		}

		return patients;
	}

	private void setupPatient(Patient patient, CSVRecord record, PatientIdentifierType identifierType, Location defaultLocation, PersonAttributeType mothersFirstNameAttributeType) throws IOException {
		if (patient == null) {
			throw new IllegalArgumentException("Patient cannot be null");
		}

		if (record == null) {
			throw new IllegalArgumentException("Record cannot be null");
		}

		if (patient.getPatientIdentifier(identifierType) == null) {
			patient.addIdentifier(new PatientIdentifier(record.get("SUBJECT_ID"), identifierType, defaultLocation));
		}
		Person person = patient.getPerson();
		setupPersonName(person, record);
		person.setGender(record.get("GENDER"));

		Date birthdate;
		try {
			birthdate = DATE_FORMAT.parse(record.get("DOB"));
		} catch (ParseException e) {
			throw new IOException(e);
		}
		person.setBirthdate(birthdate);

		if (person.getAttribute(mothersFirstNameAttributeType.getId()) == null) {
			PersonAttribute attribute = new PersonAttribute();
			attribute.setAttributeType(mothersFirstNameAttributeType);
			attribute.setValue(record.get("MOTHERS_NAME"));
			person.addAttribute(attribute);
		}

		if (person.getAddresses().size() == 0) {
			PersonAddress address = getDefaultAddress();
			address.setStartDate(birthdate);
			person.addAddress(address);
		}
	}

	private void setupPersonName(Person person, CSVRecord record) {
		if (person == null) {
			throw new IllegalArgumentException("Person cannot be null");
		}

		if (record == null) {
			throw new IllegalArgumentException("Record cannot be null");
		}

		PersonName name = person.getPersonName();
		if (name == null) {
			name = new PersonName();
			person.addName(name);
		}
		name.setGivenName(record.get("FORENAME"));
		name.setFamilyName(record.get("SURNAME"));
	}

}
