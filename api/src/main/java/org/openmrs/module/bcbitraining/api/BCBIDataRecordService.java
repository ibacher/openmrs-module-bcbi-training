/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.bcbitraining.api;

import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.bcbitraining.BCBIDataRecord;

import static org.openmrs.module.bcbitraining.BCBITrainingPrivilegeConstants.*;

@SuppressWarnings("unused")
public interface BCBIDataRecordService extends OpenmrsService {

	@Authorized(GET_DATA_RECORDS)
	BCBIDataRecord getDataRecord(Integer id) throws APIException;

	@Authorized(GET_DATA_RECORDS)
	BCBIDataRecord getDataRecordByUuid(String uuid) throws APIException;

	@Authorized(GET_DATA_RECORDS)
	BCBIDataRecord getDataRecordByFile(String file) throws APIException;

	@Authorized(EDIT_DATA_RECORDS)
	BCBIDataRecord retireDataRecord(BCBIDataRecord dataRecord, String retireReason) throws APIException;

	@Authorized(EDIT_DATA_RECORDS)
	BCBIDataRecord saveDataRecord(BCBIDataRecord dataRecord) throws APIException;

}
