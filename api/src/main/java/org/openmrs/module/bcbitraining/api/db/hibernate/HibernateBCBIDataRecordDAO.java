/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.bcbitraining.api.db.hibernate;

import static org.hibernate.criterion.Restrictions.and;
import static org.hibernate.criterion.Restrictions.eq;

import java.util.List;

import lombok.Setter;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.bcbitraining.BCBIDataRecord;
import org.openmrs.module.bcbitraining.api.db.BCBIDataRecordDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SuppressWarnings("unused")
public class HibernateBCBIDataRecordDAO implements BCBIDataRecordDAO {

	private static final Logger log = LoggerFactory.getLogger(HibernateBCBIDataRecordDAO.class);

	@Setter
	private DbSessionFactory sessionFactory;

	@Override
	@Transactional(readOnly = true)
	public BCBIDataRecord getDataRecord(Integer id) throws DAOException {
		return (BCBIDataRecord) sessionFactory.getCurrentSession().get(BCBIDataRecord.class, id);
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public BCBIDataRecord getDataRecordByUuid(String uuid) throws DAOException {
		List<BCBIDataRecord> results = (List<BCBIDataRecord>) sessionFactory.getCurrentSession()
				.createCriteria(BCBIDataRecord.class).add(
						and(eq("uuid", uuid),
								eq("retired", false))).setMaxResults(1).list();

		if (results.size() == 0) {
			return null;
		}

		return results.get(0);
	}

	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public BCBIDataRecord getDataRecordByFile(String file) throws DAOException {
		List<BCBIDataRecord> results = (List<BCBIDataRecord>) sessionFactory.getCurrentSession()
				.createCriteria(BCBIDataRecord.class).add(
						and(eq("file", file),
								eq("retired", false))).setMaxResults(1).list();

		if (results.size() == 0) {
			return null;
		}

		return results.get(0);
	}

	@Override
	public BCBIDataRecord saveDataRecord(BCBIDataRecord dataRecord) throws DAOException {
		DbSession currentSession = sessionFactory.getCurrentSession();

		if (dataRecord.getRetired() == null) {
			dataRecord.setRetired(false);
		}
		currentSession.saveOrUpdate(dataRecord);
		currentSession.flush();
		currentSession.refresh(dataRecord);

		return dataRecord;
	}

}
