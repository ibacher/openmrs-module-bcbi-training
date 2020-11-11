/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.bcbitraining.metadata;

import org.openmrs.ConceptName;
import org.openmrs.module.bcbitraining.descriptor.mds.ConceptNameDescriptor;

public class BCBIMetadataUtils {
	
	public static ConceptName createConceptName(ConceptNameDescriptor nameDescriptor) {
		ConceptName conceptName = new ConceptName();
		conceptName.setName(nameDescriptor.name());
		conceptName.setLocale(nameDescriptor.locale());
		conceptName.setLocalePreferred(nameDescriptor.preferred());
		conceptName.setConceptNameType(nameDescriptor.nameType());
		conceptName.setUuid(nameDescriptor.uuid());
		return conceptName;
	}
	
}
