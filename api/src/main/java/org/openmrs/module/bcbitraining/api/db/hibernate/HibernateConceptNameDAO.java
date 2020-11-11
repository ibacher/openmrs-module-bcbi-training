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

import lombok.Setter;
import org.openmrs.ConceptName;
import org.openmrs.api.context.Context;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.bcbitraining.api.db.ConceptNameDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import static org.hibernate.criterion.Restrictions.eq;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

@SuppressWarnings("unused")
public class HibernateConceptNameDAO implements ConceptNameDAO {
	
	private static final Logger log = LoggerFactory.getLogger(HibernateConceptNameDAO.class);

	@Setter
	private DbSessionFactory sessionFactory;
	
	@Override
	@Transactional(readOnly = true)
	public ConceptName getConceptName(Integer id) throws DAOException {
		return (ConceptName) sessionFactory.getCurrentSession().get(ConceptName.class, id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public ConceptName getConceptNameByName(String name) throws DAOException {
		return getConceptNameByName(name, Context.getLocale());
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public ConceptName getConceptNameByName(String name, Locale locale) {
		List<ConceptName> results = Collections.unmodifiableList((List<ConceptName>) sessionFactory.getCurrentSession()
		        .createCriteria(ConceptName.class).add(eq("name", name)).setMaxResults(1).list());
		
		if (results.size() == 0) {
			return null;
		}
		
		return results.get(0);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public ConceptName getConceptNameByUuid(String uuid) throws DAOException {
		List<ConceptName> results = Collections.unmodifiableList((List<ConceptName>) sessionFactory.getCurrentSession()
		        .createCriteria(ConceptName.class).add(eq("uuid", uuid)).setMaxResults(1).list());
		
		if (results.size() == 0) {
			return null;
		}
		
		return results.get(0);
	}
}
