package org.openmrs.module.bcbitraining.descriptor.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openmrs.Location;

@EqualsAndHashCode(callSuper = false)
@Data
public class LocationDescriptor extends DataDescriptor<Location> {

	private Integer id;

	private String uuid;

}
