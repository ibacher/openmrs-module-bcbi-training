package org.openmrs.module.bcbitraining.descriptor.data;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openmrs.Encounter;

@EqualsAndHashCode(callSuper = false)
@Data(staticConstructor = "of")
public class EncounterDescriptor extends DataDescriptor<Encounter> {

	private String uuid;

	private String encounterTypeUuid;

	private Date dateTime;

	private LocationDescriptor location;

	private FormDescriptor form;

	private PatientDescriptor patient;

	private List<OrderDescriptor> orders;

	private List<ObsDescriptor> obs;

	private List<ProviderDescriptor> providers;

}
