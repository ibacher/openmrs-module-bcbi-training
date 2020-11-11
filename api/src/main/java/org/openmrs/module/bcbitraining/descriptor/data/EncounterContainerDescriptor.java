package org.openmrs.module.bcbitraining.descriptor.data;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class EncounterContainerDescriptor {

	private List<EncounterDescriptor> encounters;

}
