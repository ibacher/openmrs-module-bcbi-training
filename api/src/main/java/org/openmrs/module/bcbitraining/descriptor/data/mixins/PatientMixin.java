package org.openmrs.module.bcbitraining.descriptor.data.mixins;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.openmrs.module.bcbitraining.descriptor.data.PersonDescriptor;

@SuppressWarnings("unused")
public interface PatientMixin {

	@JsonUnwrapped
	PersonDescriptor getPerson();

}
