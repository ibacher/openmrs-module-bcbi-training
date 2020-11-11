package org.openmrs.module.bcbitraining.descriptor.data;

import net.jodah.typetools.TypeResolver;
import org.openmrs.OpenmrsObject;

public abstract class DataDescriptor<T extends OpenmrsObject> {

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	protected DataDescriptor() {
		this.clazz = (Class<T>) TypeResolver.resolveRawArgument(DataDescriptor.class, getClass());
	}

	@SuppressWarnings("unused")
	public Class<T> getDescribedType() {
		return clazz;
	}

}
