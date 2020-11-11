package org.openmrs.module.bcbitraining.descriptor.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openmrs.Person;

@EqualsAndHashCode(callSuper = false)
@Data
public class PersonDescriptor extends DataDescriptor<Person> {

	private String givenName;
	private String middleName;
	private String familyName;

}
