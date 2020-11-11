/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.bcbitraining;

import java.util.Date;

import lombok.EqualsAndHashCode;
import org.openmrs.BaseOpenmrsData;
import org.openmrs.OpenmrsObject;
import org.openmrs.Retireable;
import org.openmrs.User;

/**
 * Persistent object representing a data file that has been read
 */
@EqualsAndHashCode(callSuper = true)
public class BCBIDataRecord extends BaseOpenmrsData implements Retireable {

	private Integer id;

	@EqualsAndHashCode.Include
	private String file;

	private byte[] hashValue;

	private Boolean retired;

	private User retiredBy;

	private Date dateRetired;

	private String retireReason;

	/**
	 * @see OpenmrsObject#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}

	/**
	 * @see OpenmrsObject#setId(Integer)
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public byte[] getHashValue() {
		return hashValue;
	}

	public void setHashValue(byte[] hashValue) {
		this.hashValue = hashValue;
	}

	public Boolean getRetired() {
		return retired;
	}

	/**
	 * @see Retireable#setRetired(Boolean)
	 */
	@Override
	public void setRetired(Boolean retired) {
		this.retired = retired;
	}

	/**
	 * @see Retireable#isRetired()
	 */
	@Override
	public Boolean isRetired() {
		return retired;
	}

	/**
	 * @see Retireable#getRetiredBy()
	 */
	@Override
	public User getRetiredBy() {
		return retiredBy;
	}

	/**
	 * @see Retireable#setRetiredBy(User)
	 */
	@Override
	public void setRetiredBy(User user) {
		this.retiredBy = user;
	}

	/**
	 * @see Retireable#getDateRetired()
	 */
	@Override
	public Date getDateRetired() {
		return dateRetired;
	}

	/**
	 * @see Retireable#setDateRetired(Date)
	 */
	@Override
	public void setDateRetired(Date date) {
		this.dateRetired = date;
	}

	/**
	 * @see Retireable#getRetireReason() ()
	 */
	@Override
	public String getRetireReason() {
		return retireReason;
	}

	/**
	 * @see Retireable#setRetireReason(String)
	 */
	@Override
	public void setRetireReason(String retireReason) {
		this.retireReason = retireReason;
	}

}
