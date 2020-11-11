package org.openmrs.module.bcbitraining.descriptor.data.mixins;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.openmrs.module.bcbitraining.descriptor.data.LocationDescriptor;
import org.openmrs.module.bcbitraining.descriptor.data.PatientDescriptor;

@SuppressWarnings("unused")
public interface ObsMixin {

	@JsonUnwrapped(prefix = "location")
	LocationDescriptor getLocation();

	@JsonUnwrapped(prefix = "patient")
	PatientDescriptor getPatient();

}
