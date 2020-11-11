package org.openmrs.module.bcbitraining.descriptor.data.mixins;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.openmrs.module.bcbitraining.descriptor.data.ConceptDescriptor;
import org.openmrs.module.bcbitraining.descriptor.data.OrderDescriptor;

@SuppressWarnings("unused")
public interface OrderMixin {

	@JsonUnwrapped(prefix = "previousOrder")
	OrderDescriptor previousOrder();

	@JsonUnwrapped(prefix = "concept")
	ConceptDescriptor getConcept();

}
