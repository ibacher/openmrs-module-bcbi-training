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

import static org.openmrs.module.bcbitraining.BCBITrainingConstants.HOSPITAL_LOCATION_UUID;
import static org.openmrs.module.bcbitraining.BCBITrainingConstants.HOSPITAL_NAME;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.openmrs.module.metadatadeploy.descriptor.LocationDescriptor;
import org.openmrs.module.metadatadeploy.descriptor.LocationTagDescriptor;
import org.openmrs.module.pihcore.metadata.core.LocationTags;

public class BCBILocations {

	public static final LocationDescriptor BCBI_BASE = new LocationDescriptor() {

		@Override
		public String uuid() {
			return HOSPITAL_LOCATION_UUID;
		}

		@Override
		public String name() {
			return HOSPITAL_NAME;
		}

		@Override
		public String description() {
			return "BCBI Hospital";
		}

		@Override
		public List<LocationTagDescriptor> tags() {
			return Arrays.asList(LocationTags.VISIT_LOCATION, LocationTags.LOGIN_LOCATION);
		}
	};

	public static final LocationDescriptor MED = new LocationDescriptor() {

		@Override
		public String uuid() {
			return "7e15fdc1-136e-4359-8fac-000773215077";
		}

		@Override
		public String name() {
			return "MED";
		}

		@Override
		public String description() {
			return "BCBI MED Service";
		}

		@Override
		public LocationDescriptor parent() {
			return BCBILocations.BCBI_BASE;
		}
	};

	public static final LocationDescriptor CMED = new LocationDescriptor() {

		@Override
		public String uuid() {
			return "236db841-bc06-465e-ab78-ab5842457aa4";
		}

		@Override
		public String name() {
			return "CMED";
		}

		@Override
		public String description() {
			return "BCBI CMED Service";
		}

		@Override
		public LocationDescriptor parent() {
			return BCBILocations.BCBI_BASE;
		}
	};

	public static final LocationDescriptor NMED = new LocationDescriptor() {

		@Override
		public String uuid() {
			return "249d5e57-f077-496d-a2ed-c2e8b7a3f981";
		}

		@Override
		public String name() {
			return "NMED";
		}

		@Override
		public String description() {
			return "BCBI NMED Service";
		}

		@Override
		public LocationDescriptor parent() {
			return BCBILocations.BCBI_BASE;
		}
	};

	public static final LocationDescriptor OMED = new LocationDescriptor() {

		@Override
		public String uuid() {
			return "90b37e33-f8fe-4322-a125-89f2fc11a23b";
		}

		@Override
		public String name() {
			return "OMED";
		}

		@Override
		public String description() {
			return "BCBI OMED Service";
		}

		@Override
		public LocationDescriptor parent() {
			return BCBILocations.BCBI_BASE;
		}
	};

	public static final LocationDescriptor SURG = new LocationDescriptor() {

		@Override
		public String uuid() {
			return "d3d9e4ab-29be-46b7-833c-292579f7f613";
		}

		@Override
		public String name() {
			return "SURG";
		}

		@Override
		public String description() {
			return "BCBI SURG Service";
		}

		@Override
		public LocationDescriptor parent() {
			return BCBILocations.BCBI_BASE;
		}
	};

	public static final LocationDescriptor CSURG = new LocationDescriptor() {

		@Override
		public String uuid() {
			return "8c16e52b-a94d-4fc5-8718-37a45b68ed1b";
		}

		@Override
		public String name() {
			return "CSURG";
		}

		@Override
		public String description() {
			return "BCBI CSURG Service";
		}

		@Override
		public LocationDescriptor parent() {
			return BCBILocations.BCBI_BASE;
		}
	};

	public static final LocationDescriptor NSURG = new LocationDescriptor() {

		@Override
		public String uuid() {
			return "e2371daf-7589-442c-a56a-6ffa994b8b7b";
		}

		@Override
		public String name() {
			return "NSURG";
		}

		@Override
		public String description() {
			return "BCBI NSURG Service";
		}

		@Override
		public LocationDescriptor parent() {
			return BCBILocations.BCBI_BASE;
		}
	};

	public static final LocationDescriptor TSURG = new LocationDescriptor() {

		@Override
		public String uuid() {
			return "94bf741e-8123-48c9-ac34-2c1d0f0137f4";
		}

		@Override
		public String name() {
			return "TSURG";
		}

		@Override
		public String description() {
			return "BCBI NSURG Service";
		}

		@Override
		public LocationDescriptor parent() {
			return BCBILocations.BCBI_BASE;
		}
	};

	public static final LocationDescriptor VSURG = new LocationDescriptor() {

		@Override
		public String uuid() {
			return "4a79b8db-ea93-4c74-805e-a0fc8ce04e14";
		}

		@Override
		public String name() {
			return "VSURG";
		}

		@Override
		public String description() {
			return "BCBI VSURG Service";
		}

		@Override
		public LocationDescriptor parent() {
			return BCBILocations.BCBI_BASE;
		}
	};

	public static final LocationDescriptor TRAUM = new LocationDescriptor() {

		@Override
		public String uuid() {
			return "77772cbb-05b2-4f02-8824-1f1f8238c22a";
		}

		@Override
		public String name() {
			return "TRAUM";
		}

		@Override
		public String description() {
			return "BCBI TRAUM Service";
		}

		@Override
		public LocationDescriptor parent() {
			return BCBILocations.BCBI_BASE;
		}
	};

	public static final LocationDescriptor ORTHO = new LocationDescriptor() {

		@Override
		public String uuid() {
			return "92367811-bb25-47c8-a7a5-ebdd4c22324e";
		}

		@Override
		public String name() {
			return "ORTHO";
		}

		@Override
		public String description() {
			return "BCBI ORTHO Service";
		}

		@Override
		public LocationDescriptor parent() {
			return BCBILocations.BCBI_BASE;
		}
	};

	public static final Collection<LocationDescriptor> ALL_LOCATIONS = new LinkedHashSet<>(
			Collections.singletonList(BCBI_BASE));
}
