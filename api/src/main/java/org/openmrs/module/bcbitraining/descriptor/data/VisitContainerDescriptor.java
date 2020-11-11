package org.openmrs.module.bcbitraining.descriptor.data;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class VisitContainerDescriptor {

	private List<VisitDescriptor> visits;

}
