/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.bcbitraining;

import static org.openmrs.module.bcbitraining.BCBITrainingConstants.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang.time.DateUtils;
import org.openmrs.*;
import org.openmrs.api.*;
import org.openmrs.api.context.Context;
import org.openmrs.module.BaseModuleActivator;
import org.openmrs.module.ModuleFactory;
import org.openmrs.module.bcbitraining.api.ConceptNameService;
import org.openmrs.module.bcbitraining.data.PatientRecordHandler;
import org.openmrs.module.bcbitraining.data.PatientRegistrationHandler;
import org.openmrs.module.bcbitraining.data.PatientVitalsHandler;
import org.openmrs.module.bcbitraining.descriptor.mds.ConceptDescriptor;
import org.openmrs.module.bcbitraining.descriptor.mds.ConceptMapDescriptor;
import org.openmrs.module.bcbitraining.descriptor.mds.ConceptNameDescriptor;
import org.openmrs.module.bcbitraining.encounter.matcher.BCBIVitalsEncounterMatcher;
import org.openmrs.module.bcbitraining.metadata.BCBIDiagnosisConcepts;
import org.openmrs.module.bcbitraining.metadata.BCBIDrugConcepts;
import org.openmrs.module.bcbitraining.metadata.BCBILabConcepts;
import org.openmrs.module.bcbitraining.metadata.BCBILocations;
import org.openmrs.module.bcbitraining.task.CloseStaleVisitsTask;
import org.openmrs.module.emr.EmrConstants;
import org.openmrs.module.emrapi.account.AccountDomainWrapper;
import org.openmrs.module.emrapi.account.AccountService;
import org.openmrs.module.emrapi.encounter.EmrEncounterService;
import org.openmrs.module.emrapi.encounter.domain.EncounterTransaction;
import org.openmrs.module.idgen.SequentialIdentifierGenerator;
import org.openmrs.module.idgen.service.IdentifierSourceService;
import org.openmrs.module.metadatadeploy.bundle.CoreConstructors;
import org.openmrs.module.metadatadeploy.descriptor.Descriptor;
import org.openmrs.module.metadatadeploy.descriptor.LocationDescriptor;
import org.openmrs.module.metadatadeploy.descriptor.LocationTagDescriptor;
import org.openmrs.module.owa.AppManager;
import org.openmrs.module.pihcore.metadata.core.LocationTags;
import org.openmrs.module.providermanagement.ProviderRole;
import org.openmrs.module.providermanagement.api.ProviderManagementService;
import org.openmrs.scheduler.SchedulerException;
import org.openmrs.scheduler.SchedulerService;
import org.openmrs.scheduler.TaskDefinition;
import org.openmrs.util.OpenmrsConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openmrs.module.bcbitraining.metadata.BCBIMetadataUtils.*;

/**
 * This class contains the logic that is run every time this module is either started or shutdown
 */
public class BCBITrainingActivator extends BaseModuleActivator {
	
	private final Logger log = LoggerFactory.getLogger("org.openmrs.api");
	
	private Map<String, ConceptSource> conceptSources;

	/**
	 * @see #started()
	 */
	@Override
	public void started() {
		log.info("Starting BCBI Training Module");
		try {
			// set the default locale to English
			updateGlobalProperty(OpenmrsConstants.GLOBAL_PROPERTY_DEFAULT_LOCALE, Locale.ENGLISH.getLanguage());

			// set the correct OWA directory for the environment
			String appDataDirectory = (String) Context.getRuntimeProperties()
					.get(OpenmrsConstants.APPLICATION_DATA_DIRECTORY_RUNTIME_PROPERTY);
			updateGlobalProperty(AppManager.KEY_APP_FOLDER_PATH,
					Paths.get(appDataDirectory, "owa").toAbsolutePath().toString());

			// stop the task that closes stale visits
			stopStaleVisitsTask();

			// populate missing concepts
			ConceptService conceptService = Context.getConceptService();

			// we only reference a small number concept sources, so save them for later
			conceptSources = new HashMap<>(3);
			conceptSources.put("CIEL", conceptService.getConceptSourceByName("CIEL"));
			conceptSources.put("PIH", conceptService.getConceptSourceByName("PIH"));
			conceptSources.put("LOINC", conceptService.getConceptSourceByName("LOINC"));

			ConceptNameService conceptNameService = Context.getService(ConceptNameService.class);

			createMissingDrugConcepts(conceptService, conceptNameService);
			createMissingDiagnosisConcepts(conceptService, conceptNameService);
			createMissingLabConcepts(conceptService, conceptNameService);

			IdentifierSourceService identifierSourceService = Context.getService(IdentifierSourceService.class);

			createBCBIPatientIdentifier(identifierSourceService);

			PatientService patientService = Context.getPatientService();

			// MIMIC IDs don't validate according to the LuhnMod30 algorithm PIH uses, so we will ignore this validation
			// requirement
			disableZLIdLuhnCheck(patientService);

			// setup locations
			LocationService locationService = Context.getLocationService();

			// first, untag the login locations the PIH EMR has added
			unflagNonBCBILocations(locationService);

			// second, create our locations
			createBCBILocations(locationService);

			// third, add all the appropriate tags to our locations
			setupConsultLocations(locationService);

			// finally, set the default location
			updateGlobalProperty(OpenmrsConstants.GLOBAL_PROPERTY_DEFAULT_LOCATION_NAME, HOSPITAL_NAME);

			UserService userService = Context.getUserService();
			addPermissionsToPhysicianRole(userService);

			// setup the users
			AccountService accountService = Context.getService(AccountService.class);
			ProviderManagementService providerManagementService = Context.getService(ProviderManagementService.class);
			setupUsers(userService, accountService, providerManagementService);

			// now we begin loading the bundled data
			Location bcbiHospital = locationService.getLocationByUuid(HOSPITAL_LOCATION_UUID);
			PersonService personService = Context.getPersonService();
			createPatients(patientService, personService, bcbiHospital);

			EmrEncounterService emrEncounterService = Context.getService(EmrEncounterService.class);
			EncounterService encounterService = Context.getEncounterService();
			FormService formService = Context.getFormService();

			createRegistrationEncounters(emrEncounterService, encounterService, formService, conceptService, patientService,
					providerManagementService);

			Object originalValue = getGlobalProperty(GP_ENCOUNTER_MATCHER);
			// ensure that we always create a new encounter for each vitals encounter
			updateGlobalProperty(GP_ENCOUNTER_MATCHER, BCBIVitalsEncounterMatcher.class.getName());

			VisitService visitService = Context.getVisitService();
			createVitalEncounters(emrEncounterService, encounterService, formService, conceptService, patientService,
					providerManagementService, visitService);

			updateGlobalProperty(GP_ENCOUNTER_MATCHER, originalValue);

			// I don't know why BCBI has the Login tag removed, but add it back!
			ensureLoginLocation(locationService);

			// Since we've just loaded a bunch of data, rebuild the Lucene index
			Context.updateSearchIndexAsync();
		} catch (Exception e) {
			ModuleFactory.stopModule(ModuleFactory.getModuleById("bcbitraining"), true, true);
			throw new RuntimeException("failed to start BCBI Training Module", e);
		}

		log.info("Started BCBI Training Module");
	}

	private void addPermissionsToPhysicianRole(UserService userService) {
		Role physician = userService.getRole("Application Role: physician");
		physician.addPrivilege(userService.getPrivilege("App: dispensing.app.dispense"));
		physician.addPrivilege(userService.getPrivilege("App: mirebalaisreports.dataexports"));
		physician.addPrivilege(userService.getPrivilege("App: reportingui.reports"));
		physician.addPrivilege(userService.getPrivilege("App: reportingui.adHocAnalysis"));
		physician.addPrivilege(userService.getPrivilege("App: cohortBuilder"));
		userService.saveRole(physician);
	}

	private void createBCBILocations(LocationService locationService) {
		// note that all the LocationTags we need are already included in the PIH EMR metadata
		for (LocationDescriptor locationDescriptor : BCBILocations.ALL_LOCATIONS) {
			Location location = locationService.getLocationByUuid(locationDescriptor.uuid());
			
			if (location == null) {
				Collection<String> tags = new LinkedHashSet<>();
				for (LocationTagDescriptor tagDescriptor : locationDescriptor.tags()) {
					tags.add(tagDescriptor.uuid());
				}
				
				String parentUuid = null;
				if (locationDescriptor.parent() != null) {
					parentUuid = locationDescriptor.parent().uuid();
				}
				
				location = CoreConstructors.location(locationDescriptor.name(), locationDescriptor.description(),
				    locationDescriptor.uuid(), parentUuid, tags);
			} else {
				Collection<String> tagNames = new LinkedHashSet<>();
				for (LocationTagDescriptor tagDescriptor : locationDescriptor.tags()) {
					tagNames.add(tagDescriptor.name());
				}
				
				Collection<String> currentTagNames = new LinkedHashSet<>();
				Collection<LocationTag> tagsToRemove = new LinkedHashSet<>();
				for (LocationTag tag : location.getTags()) {
					if (!tagNames.contains(tag.getName())) {
						tagsToRemove.add(tag);
					} else {
						currentTagNames.add(tag.getName());
					}
				}
				
				for (LocationTag tag : tagsToRemove) {
					location.removeTag(tag);
				}
				
				tagNames.removeAll(currentTagNames);
				
				for (String tagName : tagNames) {
					if (!location.hasTag(tagName)) {
						LocationTag tag = locationService.getLocationTagByName(tagName);
						location.addTag(tag);
					}
				}
			}
			
			locationService.saveLocation(location);
		}
	}

	private void createBCBIPatientIdentifier(IdentifierSourceService identifierSourceService) {
		SequentialIdentifierGenerator bcbiSource = (SequentialIdentifierGenerator)
				identifierSourceService.getIdentifierSourceByUuid(BCBI_PATIENT_ID_SOURCE_UUID);

		if (bcbiSource == null) {
			bcbiSource = new SequentialIdentifierGenerator();
		}

		bcbiSource.setMinLength(5);
		bcbiSource.setMaxLength(5);
		bcbiSource.setBaseCharacterSet("0123456789");
		bcbiSource.setPrefix(null);
		bcbiSource.setSuffix(null);
		bcbiSource.setFirstIdentifierBase("60000");

		identifierSourceService.saveIdentifierSource(bcbiSource);
	}
	
	private void createMissingDrugConcepts(ConceptService conceptService, ConceptNameService conceptNameService) {
		ConceptClass drug = conceptService.getConceptClassByUuid(DRUG_CLASS_UUID);
		ConceptDatatype na = conceptService.getConceptDatatypeByUuid(NA_DATATYPE_UUID);
		
		for (ConceptDescriptor conceptDescriptor : BCBIDrugConcepts.ALL_DRUGS) {
			createConcept(conceptService, conceptNameService, conceptDescriptor, drug, na);
		}
	}
	
	private void createMissingDiagnosisConcepts(ConceptService conceptService, ConceptNameService conceptNameService) {
		ConceptClass diagnosis = conceptService.getConceptClassByUuid(DIAGNOSIS_CLASS_UUID);
		ConceptDatatype na = conceptService.getConceptDatatypeByUuid(NA_DATATYPE_UUID);
		
		for (ConceptDescriptor conceptDescriptor : BCBIDiagnosisConcepts.ALL_DIAGNOSES) {
			createConcept(conceptService, conceptNameService, conceptDescriptor, diagnosis, na);
		}
	}
	
	private void createMissingLabConcepts(ConceptService conceptService, ConceptNameService conceptNameService) {
		ConceptClass test = conceptService.getConceptClassByUuid(TEST_CLASS_UUID);
		
		for (ConceptDescriptor conceptDescriptor : BCBILabConcepts.ALL_LABS) {
			createConcept(conceptService, conceptNameService, conceptDescriptor, test);
		}
	}

	@SuppressWarnings("unused")
	private void createConcept(ConceptService conceptService, ConceptNameService conceptNameService,
	        ConceptDescriptor conceptDescriptor) {
		createConcept(conceptService, conceptNameService, conceptDescriptor, null, null);
	}
	
	private void createConcept(ConceptService conceptService, ConceptNameService conceptNameService,
	        ConceptDescriptor conceptDescriptor, ConceptClass conceptClass) {
		createConcept(conceptService, conceptNameService, conceptDescriptor, conceptClass, null);
	}
	
	private void createConcept(ConceptService conceptService, ConceptNameService conceptNameService,
	        ConceptDescriptor conceptDescriptor, ConceptClass conceptClass, ConceptDatatype conceptDatatype) {
		
		if (conceptService.getConceptByUuid(conceptDescriptor.uuid()) != null) {
			return;
		}
		
		log.info("Working on concept {}", conceptDescriptor.names().iterator().next().name());
		
		Concept concept;
		for (ConceptNameDescriptor conceptNameDescriptor : conceptDescriptor.names()) {
			concept = conceptService.getConceptByName(conceptNameDescriptor.name());
			if (concept != null) {
				log.info("Concept named {} already exists so updating it", conceptNameDescriptor.name());
				Set<String> names = new LinkedHashSet<>();
				for (ConceptName name : concept.getNames(Locale.ENGLISH)) {
					names.add(name.getName().toLowerCase(Locale.ENGLISH));
				}
				
				for (ConceptNameDescriptor nameDescriptor : conceptDescriptor.names()) {
					if (!names.contains(nameDescriptor.name().toLowerCase(Locale.ENGLISH))) {
						ConceptName conceptName = createConceptName(nameDescriptor);
						
						names.add(nameDescriptor.name());
						concept.addName(conceptName);
					}
				}
				
				for (ConceptMap conceptMap : generateConceptMaps(conceptService, conceptDescriptor)) {
					concept.addConceptMapping(conceptMap);
				}
				
				conceptService.saveConcept(concept);
				return;
			}
		}
		
		log.info("Creating concept {}", conceptDescriptor.names().iterator().next().name());
		
		concept = new Concept();
		if (conceptClass != null) {
			concept.setConceptClass(conceptClass);
		} else {
			concept.setConceptClass(conceptService.getConceptClassByName(conceptDescriptor.conceptClass().name()));
		}
		
		if (conceptDatatype != null) {
			concept.setDatatype(conceptDatatype);
		} else {
			concept.setDatatype(conceptService.getConceptDatatypeByName(conceptDescriptor.datatype().name()));
		}
		
		for (ConceptNameDescriptor nameDescriptor : conceptDescriptor.names()) {
			ConceptName conceptName = null;
			if (nameDescriptor.uuid() != null) {
				conceptName = conceptNameService.getConceptNameByUuid(nameDescriptor.uuid());
			}
			
			if (conceptName == null) {
				conceptName = conceptNameService.getConceptNameByName(nameDescriptor.name());
			}
			
			if (conceptName == null) {
				conceptName = createConceptName(nameDescriptor);
			}
			
			concept.addName(conceptName);
		}
		
		for (ConceptMap conceptMap : generateConceptMaps(conceptService, conceptDescriptor)) {
			concept.addConceptMapping(conceptMap);
		}
		
		conceptService.saveConcept(concept);
	}

	private void disableZLIdLuhnCheck(PatientService patientService) {
		PatientIdentifierType zlEmrIdType = patientService.getPatientIdentifierTypeByUuid(ZL_EMR_PATIENT_ID_TYPE_UUID);
		zlEmrIdType.setValidator(null);
		patientService.savePatientIdentifierType(zlEmrIdType);
	}
	
	private Collection<ConceptMap> generateConceptMaps(ConceptService conceptService, ConceptDescriptor conceptDescriptor) {
		// NB This **MUST** be a Set<ConceptMap>
		Collection<ConceptMap> conceptMaps = new HashSet<>();
		ConceptMapType SAME_AS = conceptService.getConceptMapTypeByName("SAME-AS");
		for (ConceptMapDescriptor mapDescriptor : conceptDescriptor.sameAs()) {
			Concept concept = conceptService.getConceptByMapping(mapDescriptor.conceptReference().code(), mapDescriptor
			        .conceptReference().conceptSource().name(), false);
			
			if (concept == null) {
				ConceptSource conceptSource = conceptSources.get(mapDescriptor.conceptReference().conceptSource().name());
				String code = mapDescriptor.conceptReference().code();
				
				ConceptReferenceTerm referenceTerm = conceptService.getConceptReferenceTermByCode(code, conceptSource);
				if (referenceTerm == null) {
					referenceTerm = new ConceptReferenceTerm(conceptSource, code, null);
				}
				
				ConceptMap conceptMap = new ConceptMap();
				conceptMap.setConceptReferenceTerm(referenceTerm);
				conceptMap.setConceptMapType(SAME_AS);
				
				conceptMaps.add(conceptMap);
			}
		}
		
		return conceptMaps;
	}

	private void ensureLoginLocation(LocationService locationService) {
		LocationTag loginLocation = locationService.getLocationTagByUuid(LocationTags.LOGIN_LOCATION.uuid());
		List<Location> loginLocations =  locationService.getLocationsByTag(loginLocation);
		if (loginLocations == null || loginLocations.size() == 0) {
			Location bcbiHospital = locationService.getLocationByUuid(HOSPITAL_LOCATION_UUID);
			bcbiHospital.addTag(loginLocation);
			locationService.saveLocation(bcbiHospital);
		}
	}
	
	// note that our assumption here is that login locations are the only locations of interest
	private void unflagNonBCBILocations(LocationService locationService) {
		for (Location location : locationService.getAllLocations(false)) {
			if (!location.getUuid().equals(HOSPITAL_LOCATION_UUID)) {
				for (LocationTag tag : new LinkedHashSet<>(location.getTags())) {
					location.removeTag(tag);
				}
				locationService.saveLocation(location);
			}
		}
	}

	private static Object getGlobalProperty(String name) {
		AdministrationService administrationService = Context.getAdministrationService();
		GlobalProperty gp = administrationService.getGlobalPropertyObject(name);
		if (gp != null) {
			return gp.getValue();
		} else {
			return null;
		}
	}
	
	private static void updateGlobalProperty(String name, Object value) {
		AdministrationService administrationService = Context.getAdministrationService();
		GlobalProperty gp = administrationService.getGlobalPropertyObject(name);
		gp.setPropertyValue(value == null ? "" : value.toString());
		administrationService.saveGlobalProperty(gp);
	}
	
	private void setupConsultLocations(LocationService locationService) {
		setLocationTagsFor(locationService, LocationTags.CHECKIN_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.CONSULT_NOTE_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.PRIMARY_CARE_CONSULT_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.ED_TRIAGE_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.HIV_CONSULT_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.MEDICAL_RECORD_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.REGISTRATION_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.VITALS_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.MENTAL_HEALTH_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.PROVIDER_MANAGEMENT_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.NCD_CONSULT_LOCATION, BCBILocations.ALL_LOCATIONS);
		
		setLocationTagsFor(locationService, LocationTags.ADMISSION_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.ADMISSION_NOTE_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.APPOINTMENT_LOCATION, null);
		setLocationTagsFor(locationService, LocationTags.ARCHIVES_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.CHEMOTHERAPY_LOCATION, null);
		setLocationTagsFor(locationService, LocationTags.DISPENSING_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.ED_NOTE_LOCATION, null);
		setLocationTagsFor(locationService, LocationTags.ED_REGISTRATION_LOCATION, null);
		setLocationTagsFor(locationService, LocationTags.IDENTIFIER_ASSIGNMENT_LOCATION, null);
		setLocationTagsFor(locationService, LocationTags.INPATIENTS_APP_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.LAB_RESULTS_LOCATION, BCBILocations.ALL_LOCATIONS);
		setLocationTagsFor(locationService, LocationTags.ONCOLOGY_CONSULT_LOCATION, null);
		setLocationTagsFor(locationService, LocationTags.ORDER_PATHOLOGY_LOCATION, null);
		setLocationTagsFor(locationService, LocationTags.ORDER_RADIOLOGY_STUDY_LOCATION, null);
		setLocationTagsFor(locationService, LocationTags.SURGERY_NOTE_LOCATION, null);
		setLocationTagsFor(locationService, LocationTags.TRANSFER_LOCAITON, BCBILocations.ALL_LOCATIONS);
	}
	
	private static void setLocationTagsFor(LocationService service, LocationTagDescriptor locationTag,
	        Collection<LocationDescriptor> locationsThatGetTag) {
		
		LocationTag tag = service.getLocationTagByUuid(locationTag.uuid());
		Set<String> locationsUuidToTag = locationsThatGetTag == null ? new LinkedHashSet<>() :
				locationsThatGetTag.stream().filter(Objects::nonNull).map(Descriptor::uuid).collect(Collectors.toSet());
		
		for (Location candidate : service.getAllLocations()) {
			boolean expected = locationsUuidToTag.contains(candidate.getUuid());
			boolean actual = candidate.hasTag(tag.getName());
			
			if (actual && !expected) {
				candidate.removeTag(tag);
				service.saveLocation(candidate);
			} else if (!actual && expected) {
				candidate.addTag(tag);
				service.saveLocation(candidate);
			}
		}
	}
	
	private void setupUsers(UserService userService, AccountService accountService, ProviderManagementService providerManagementService) {
		Set<Role> roles = new LinkedHashSet<>(2);
		roles.add(userService.getRole("Application Role: physician"));
		roles.add(userService.getRole("Application Role: archivistClerk"));
		
		Role privilegeLevel = userService.getRole("Privilege Level: High");
		
		ProviderRole physician = providerManagementService
		        .getProviderRoleByUuid(PHYSICIAN_PROVIDERROLE_UUID);
		ProviderRole pharmacist = providerManagementService
				.getProviderRoleByUuid(PHARMACIST_PROVIDERROLE_UUID);
		
		int i = 1;
		for (String[] userInfo : new String[][] { { "Jerome", "Styer", "M" }, { "Genesis", "Bucco", "F" },
		        { "Drew", "Zapato", "M" }, { "Jim", "Patillo", "M" }, { "Garrett", "Carothers", "M" },
		        { "Kaitlyn", "Villamar", "F" }, { "Marshall", "Catlow", "M" }, { "Hadley", "Cockerhan", "F" },
		        { "Patsy", "Furfey", "M" }, { "Kerri", "Hutts", "F" }, { "Helena", "Gillion", "F" },
		        { "Kristal", "Emmitt", "F" }, { "Gardner", "Dove", "M" }, { "Shane", "Besanson", "M" },
		        { "Kimberley", "Esterbrook", "F" }, { "Moses", "Dair", "M" }, { "Abby", "Metta", "F" },
		        { "Frances", "Huyett", "F" }, { "Lester", "Amerman", "M" }, { "Sophia", "Horita", "F" },
		        { "Rose", "Sarria", "F" }, { "Warren", "Castilla", "M" }, { "Kimberly", "Healy", "F" },
		        { "Anaiyah", "Vaux", "F" }, { "Elena", "Amerson", "F" }, { "Marissa", "Letendre", "F" },
		        { "Edward", "Ridder", "M" }, { "James", "Nasir", "M" }, { "Alivia", "Howden", "F" },
				{ "Juliet", "Krafter", "F" }}) {
			String userId = String.format("res%02d", i);
			
			Person person;
			User user = userService.getUserByUsername(userId);
			if (user != null) {
				person = user.getPerson();
			} else {
				person = new Person();
			}
			
			AccountDomainWrapper account = accountService.getAccountByPerson(person);
			account.setGivenName(userInfo[0]);
			account.setFamilyName(userInfo[1]);
			account.setGender(userInfo[2]);
			if (user != null) {
				account.setUsername(user.getUsername());
			} else if (account.getUser() == null || account.getUser().getUsername() == null) {
				account.setUsername(userId);
			}
			account.setPassword(String.format("OpenMRS%02d", i));
			account.setConfirmPassword(String.format("OpenMRS%02d", i));
			account.setDefaultLocale(Locale.ENGLISH);
			account.setPrivilegeLevel(privilegeLevel);
			account.setCapabilities(roles);
			account.setProviderRole(physician);
			account.setUserEnabled(true);
			
			accountService.saveAccount(account);
			
			i++;
		}
	}

	private void createPatients(PatientService patientService, PersonService personService, Location defaultLocation) {
		log.info("Creating BCBI Training patients");
		PatientRecordHandler handler = new PatientRecordHandler();
		try {
			for (Patient patient : handler.generatePatients(patientService, personService, defaultLocation)) {
				patientService.savePatient(patient);
			}
		}
		catch (IOException e) {
			log.error("Caught an IOException while handling patients", e);
			throw new RuntimeException(e);
		}
	}

	private void createRegistrationEncounters(EmrEncounterService emrEncounterService, EncounterService encounterService, FormService formService, ConceptService conceptService, PatientService patientService, ProviderManagementService providerManagementService) {
		log.info("Creating BCBI Training registration encounters");
		PatientRegistrationHandler handler = new PatientRegistrationHandler();
		try {
			for (EncounterTransaction transaction : handler.generateRegistrationEncounters(conceptService, patientService, providerManagementService)) {
				log.info("Working on registration encounter for {}", transaction.getPatientUuid());
				transaction = emrEncounterService.save(transaction);

				if (transaction.getEncounterTypeUuid() != null && transaction.getEncounterTypeUuid().equals(ADMISSION_ENCOUNTER_TYPE_UUID)) {
					Encounter encounter = encounterService.getEncounterByUuid(transaction.getEncounterUuid());
					if (encounter != null) {
						encounter.setForm(formService.getForm("Admission"));
						encounterService.saveEncounter(encounter);
					}
				}
			}
		} catch (IOException e) {
			log.error("Caught an IOException while handling registration encounters", e);
			throw new RuntimeException(e);
		}
	}

	private void createVitalEncounters(EmrEncounterService emrEncounterService, EncounterService encounterService, FormService formService, ConceptService conceptService, PatientService patientService, ProviderManagementService providerManagementService, VisitService visitService) {
		log.info("Creating BCBI Training vitals encounters");
		PatientVitalsHandler handler = new PatientVitalsHandler();
		try {
			for (EncounterTransaction transaction : handler.generateVitalsEncounters(conceptService, patientService, providerManagementService, visitService)) {
				log.info("Working on vitals encounter for {}", transaction.getPatientUuid());
				transaction = emrEncounterService.save(transaction);

				Encounter encounter = encounterService.getEncounterByUuid(transaction.getEncounterUuid());
				encounter.setForm(formService.getForm("Vitals"));
				encounterService.saveEncounter(encounter);
			}
		} catch (IOException e) {
			log.error("Caught an IOException while handling vital encounters", e);
			throw new RuntimeException(e);
		}
	}

	private void stopStaleVisitsTask() {
		SchedulerService schedulerService = Context.getSchedulerService();
		TaskDefinition closeStaleVisitsTask = schedulerService.getTaskByName(EmrConstants.TASK_CLOSE_STALE_VISITS_NAME);

		if (!(closeStaleVisitsTask.getTaskInstance() instanceof CloseStaleVisitsTask)) {
			try {
				schedulerService.shutdownTask(closeStaleVisitsTask);
			}
			catch (SchedulerException e) {
				log.error("Error while closing closeStaleVisits task", e);
			}

			closeStaleVisitsTask.setStarted(false);
			closeStaleVisitsTask.setTaskClass(CloseStaleVisitsTask.class.getName());
			closeStaleVisitsTask.setStartTime(DateUtils.addMinutes(new Date(), 5));
			closeStaleVisitsTask.setRepeatInterval(0L);
			closeStaleVisitsTask.setStartOnStartup(true);
			schedulerService.saveTaskDefinition(closeStaleVisitsTask);
		}

		if (!closeStaleVisitsTask.getStarted()) {
			closeStaleVisitsTask.setStarted(true);
			
			try {
				schedulerService.scheduleTask(closeStaleVisitsTask);
			}
			catch (SchedulerException e) {
				log.error("Error while starting closeStaleVisits task", e);
			}
		}
	}
	
	/**
	 * @see #stopped()
	 */
	@Override
	public void stopped() {
		log.info("Shutdown BCBI Training");
	}
	
}
