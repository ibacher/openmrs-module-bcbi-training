package org.openmrs.module.bcbitraining.descriptor.data;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openmrs.Obs;

@EqualsAndHashCode(callSuper = false)
@Data
public class ObsDescriptor extends DataDescriptor<Obs> {

	private String uuid;
	private Date dateTime;
	private PatientDescriptor patient;
	private LocationDescriptor location;
	private Object value;
	private List<ObsDescriptor> obs;
	private String formNamespaceAndPath;
	private String comment;

}
