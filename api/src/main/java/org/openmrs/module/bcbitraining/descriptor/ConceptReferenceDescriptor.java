/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.bcbitraining.descriptor;

import org.openmrs.ConceptReferenceTerm;
import org.openmrs.module.metadatadeploy.descriptor.MetadataDescriptor;

public abstract class ConceptReferenceDescriptor extends MetadataDescriptor {
	
	@Override
	public String name() {
		throw new IllegalStateException();
	}
	
	@Override
	public String uuid() {
		throw new IllegalStateException();
	}
	
	@Override
	public String description() {
		throw new IllegalStateException();
	}
	
	@Override
	public Class getDescribedType() {
		return ConceptReferenceTerm.class;
	}
	
	abstract public ConceptSourceDescriptor conceptSource();
	
	abstract public String code();
	
}
