package com.sogeti.nl.forecast.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sogeti.nl.forecast.enums.Status;

/**
 * 
 */

/**
 * @author takhade
 *
 */
@Entity
public class Region implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5704222503252328862L;

	@Id
	@Column(name = "Region_Code", length = 2)
	@GeneratedValue
	private String regionCode;
	
	@Column(name = "Region_Name", length = 20)
	private String regionName;

	@Column(name = "Status", length = 10)
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	public Region() {
	}

	/**
	 * @param regionCode
	 * @param regionName
	 * @param project
	 */
	public Region(String regionCode, String regionName) {
		super();
		this.regionCode = regionCode;
		this.regionName = regionName;

	}

	/**
	 * Primary Key for Region
	 * 
	 * @return the regionCode
	 */
	public String getRegionCode() {
		return regionCode;
	}

	/**
	 * Primary Key for Region
	 * 
	 * @param regionCode
	 *            the regionCode to set
	 */
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	/**
	 * Region Name
	 * 
	 * @return the regionName
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * Region Name
	 * 
	 * @param regionName
	 *            the regionName to set
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}


	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

}