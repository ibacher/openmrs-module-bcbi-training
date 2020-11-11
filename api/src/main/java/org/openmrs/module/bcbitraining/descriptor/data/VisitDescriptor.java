package org.openmrs.module.bcbitraining.descriptor.data;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openmrs.Visit;

@EqualsAndHashCode(callSuper = false)
@Data
public class VisitDescriptor extends DataDescriptor<Visit> {

	private String uuid;

	private String visitTypeUuid;

	private Date startDateTime;

	private Date stopDateTime;

	private LocationDescriptor location;

	private PatientDescriptor patient;

	private List<EncounterDescriptor> encounters;

}
