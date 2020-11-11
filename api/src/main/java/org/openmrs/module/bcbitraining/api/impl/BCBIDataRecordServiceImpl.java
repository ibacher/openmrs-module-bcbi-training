/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.bcbitraining.api.impl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.bcbitraining.BCBIDataRecord;
import org.openmrs.module.bcbitraining.api.BCBIDataRecordService;
import org.openmrs.module.bcbitraining.api.db.BCBIDataRecordDAO;

@SuppressWarnings("unused")
public class BCBIDataRecordServiceImpl extends BaseOpenmrsService implements BCBIDataRecordService {

	@Setter
	private BCBIDataRecordDAO dao;

	@Override
	public boolean hasFileBeenSeen(String file) throws APIException {
		BCBIDataRecord dataRecord = getDataRecordByFile(file);

		if (dataRecord == null) {
			return false;
		}

		byte[] hashValue = dataRecord.getHashValue();
		if (hashValue == null) { return false; }

		byte[] currentHash = calculateHash(file);
		return Arrays.equals(currentHash, hashValue);
	}

	@Override
	public BCBIDataRecord getDataRecord(Integer id) {
		return dao.getDataRecord(id);
	}

	@Override
	public BCBIDataRecord getDataRecordByUuid(String uuid) {
		return dao.getDataRecordByUuid(uuid);
	}

	@Override
	public BCBIDataRecord getDataRecordByFile(String file) throws APIException {
		return dao.getDataRecordByFile(file);
	}

	@Override
	public BCBIDataRecord retireDataRecord(BCBIDataRecord dataRecord, String retireReason) {
		dataRecord.setRetired(true);
		dataRecord.setRetireReason(retireReason);
		return dao.saveDataRecord(dataRecord);
	}

	@Override
	public BCBIDataRecord saveDataRecord(BCBIDataRecord dataRecord) {
		return dao.saveDataRecord(dataRecord);
	}

	@Override
	public BCBIDataRecord saveDataRecord(String file) throws APIException {
		BCBIDataRecord dataRecord = getDataRecordByFile(file);

		if (dataRecord == null) {
			dataRecord = new BCBIDataRecord();
			dataRecord.setFile(file);
		}

		byte[] currentHash = calculateHash(file);
		dataRecord.setHashValue(currentHash);

		return saveDataRecord(dataRecord);
	}

	private byte[] calculateHash(String file) throws APIException {
		InputStream is = ClassLoader.getSystemResourceAsStream(file);
		if (is == null) {
			throw new APIException("Could not find file " + file);
		}
		BufferedInputStream bis = new BufferedInputStream(is);

		byte[] currentHash;
		try {
			currentHash = DigestUtils.sha256(bis);
		}
		catch (IOException e) {
			throw new APIException(e);
		}

		return currentHash;
	}

}
