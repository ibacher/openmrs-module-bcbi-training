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

import java.util.Locale;

import lombok.Setter;
import org.openmrs.ConceptName;
import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.bcbitraining.api.ConceptNameService;
import org.openmrs.module.bcbitraining.api.db.ConceptNameDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SuppressWarnings("unused")
public class ConceptNameServiceImpl extends BaseOpenmrsService implements ConceptNameService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Setter
	private ConceptNameDAO dao;

	@Override
	public ConceptName getConceptName(Integer id) throws APIException {
		return dao.getConceptName(id);
	}

	@Override
	public ConceptName getConceptNameByName(String name) throws APIException {
		return dao.getConceptNameByName(name);
	}

	@Override
	public ConceptName getConceptNameByName(String name, Locale locale) throws APIException {
		return dao.getConceptNameByName(name, locale);
	}

	@Override
	public ConceptName getConceptNameByUuid(String uuid) throws APIException {
		return dao.getConceptNameByUuid(uuid);
	}
}
