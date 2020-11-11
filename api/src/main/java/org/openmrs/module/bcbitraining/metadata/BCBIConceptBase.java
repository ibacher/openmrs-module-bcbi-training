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

import org.openmrs.module.bcbitraining.BCBITrainingConstants;
import org.openmrs.module.bcbitraining.descriptor.mds.ConceptDatatypeDescriptor;
import org.openmrs.module.bcbitraining.descriptor.mds.ConceptSourceDescriptor;

public class BCBIConceptBase {
	
	public static final ConceptSourceDescriptor CIEL = new ConceptSourceDescriptor() {
		
		@Override
		public String name() {
			return "CIEL";
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "21ADDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD";
		}
	};
	
	public static final ConceptSourceDescriptor PIH = new ConceptSourceDescriptor() {
		
		@Override
		public String name() {
			return "PIH";
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return null;
		}
	};
	
	public static final ConceptSourceDescriptor LOINC = new ConceptSourceDescriptor() {
		
		@Override
		public String name() {
			return "LOINC";
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return null;
		}
	};
	
	public static final ConceptDatatypeDescriptor CODED = new ConceptDatatypeDescriptor() {
		
		@Override
		public String name() {
			return "Coded";
		}
		
		@Override
		public String uuid() {
			return BCBITrainingConstants.CODED_DATATYPE_UUID;
		}
	};
	
	public static final ConceptDatatypeDescriptor NA = new ConceptDatatypeDescriptor() {
		
		@Override
		public String name() {
			return "N/A";
		}
		
		@Override
		public String uuid() {
			return BCBITrainingConstants.NA_DATATYPE_UUID;
		}
	};
	
	public static final ConceptDatatypeDescriptor NUMERIC = new ConceptDatatypeDescriptor() {
		
		@Override
		public String name() {
			return "Numeric";
		}
		
		@Override
		public String uuid() {
			return BCBITrainingConstants.NUMERIC_DATATYPE_UUID;
		}
	};
}
