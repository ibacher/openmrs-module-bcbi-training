package org.openmrs.module.bcbitraining.descriptor.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openmrs.Concept;

@EqualsAndHashCode(callSuper = false)
@Data
public class ConceptDescriptor extends DataDescriptor<Concept> {

	private Integer id;
	private String uuid;
	private String mappingSource;
	private String mappingCode;

}
