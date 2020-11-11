package org.openmrs.module.bcbitraining.descriptor.data;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openmrs.Form;

@EqualsAndHashCode(callSuper = false)
@Data
public class FormDescriptor extends DataDescriptor<Form> {

	private Integer id;
	private String uuid;

}
