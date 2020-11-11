package org.openmrs.module.bcbitraining.descriptor.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openmrs.Provider;

@EqualsAndHashCode(callSuper = false)
@Data
public class ProviderDescriptor extends DataDescriptor<Provider> {

	private String uuid;

	private String identifier;

	private PersonDescriptor person;

}
