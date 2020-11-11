package org.openmrs.module.bcbitraining.descriptor.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openmrs.Patient;

@EqualsAndHashCode(callSuper = false)
@Data
public class PatientDescriptor extends DataDescriptor<Patient> {

	private String uuid;

	private Integer id;

	private String identifier;

	private String identifierTypeUuid;

	private PersonDescriptor person;

}
