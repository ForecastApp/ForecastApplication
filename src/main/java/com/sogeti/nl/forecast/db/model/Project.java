package com.sogeti.nl.forecast.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sogeti.nl.forecast.enums.Status;

/**
 * @author takhade
 *
 */
@Entity
public class Project {

	@Id
	@Column(name = "ID", length = 5)
	@GeneratedValue
	private Integer Id;

	@Column(name = "Project_Name", length = 30)
	private String projectName;

	@Column(name = "Project_Code", length = 15)
	private Integer projectCode;

	@Column(name = "Future_Project_Code", length = 15)
	private Integer futureProjectCode;

	@ManyToOne
	@JoinColumn(name = "Region_Code")
	private Region region;

	@Column(name = "Status", length = 10)
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	
	public Project() {
	}

	/**
	 * @param id
	 * @param projectName
	 * @param projectCode
	 * @param region
	 */
	public Project(Integer id, String projectName, Integer projectCode,
			Region region) {
		super();
		Id = id;
		this.projectName = projectName;
		this.projectCode = projectCode;
		this.region = region;
	}

	/**
	 * Primary Key for Project
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * Primary Key for Project
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * Foreign Key constraint Region_Code
	 * 
	 * @return the region
	 */

	public Region getRegion() {
		return region;
	}

	/**
	 * Foreign Key constraint Region_Code
	 * 
	 * @param region
	 *            the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * Project Name
	 * 
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Project Name
	 * 
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Project Code Unique Constraint
	 * 
	 * @return the projectCode
	 */
	public Integer getProjectCode() {
		return projectCode;
	}

	/**
	 * Project Code Unique Constraint
	 * 
	 * @param projectCode
	 *            the projectCode to set
	 */
	public void setProjectCode(Integer projectCode) {
		this.projectCode = projectCode;
	}
	
	/**
	 * @return the futureProjectCode
	 */
	public Integer getFutureProjectCode() {
		return futureProjectCode;
	}

	/**
	 * @param futureProjectCode the futureProjectCode to set
	 */
	public void setFutureProjectCode(Integer futureProjectCode) {
		this.futureProjectCode = futureProjectCode;
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
