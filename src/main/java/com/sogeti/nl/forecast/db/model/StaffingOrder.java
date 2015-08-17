package com.sogeti.nl.forecast.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sogeti.nl.forecast.enums.Grade;
import com.sogeti.nl.forecast.enums.SOStatus;

/**
 * 
 */

/**
 * @author takhade
 *
 */

@Entity
public class StaffingOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3659232658305423084L;

	@Id
	@Column(name = "Id", length = 6)
	@GeneratedValue
	private Integer id;

	@Column(name = "SO_Reference_No", length = 20)
	private String soReferenceNo;

	@Column(name = "Requested_Start_Date")
	private Date requestedStartDate;

	/**
	 * Foreign Key constraint Project_Code
	 */
	@OneToOne
	@JoinColumn(name = "Project_Id", nullable = true)
	private Project Project;

	/**
	 * Foreign Key constraint Employee_Id
	 */
	@OneToOne
	@JoinColumn(name = "Employee_Id", nullable = true)
	private Employee employee;

	@Column(name = "Grade", length = 10)
	@Enumerated(EnumType.ORDINAL)
	private Grade grade;

	@Column(name = "SO_Status", length = 15)
	@Enumerated(EnumType.ORDINAL)
	private SOStatus SOStatus;

	public StaffingOrder() {
	}

	/**
	 * @param id
	 * @param soreferenceno
	 * @param requestedstartdate
	 * @param Project
	 */
	public StaffingOrder(Integer id, String soreferenceno,
			Date requestedstartdate, Project Project) {
		super();
		this.id = id;
		this.soReferenceNo = soreferenceno;
		this.requestedStartDate = requestedstartdate;
		this.setProject(Project);
	}

	/**
	 * primary key for SO
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Primary Key for SO
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the soReferenceNo
	 */
	public String getSoReferenceNo() {
		return soReferenceNo;
	}

	/**
	 * @param soReferenceNo
	 *            the soReferenceNo to set
	 */
	public void setSoReferenceNo(String soReferenceNo) {
		this.soReferenceNo = soReferenceNo;
	}

	/**
	 * @return the requestedStartDate
	 */
	public Date getRequestedStartDate() {
		return requestedStartDate;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param requestedStartDate
	 *            the requestedStartDate to set
	 */
	public void setRequestedStartDate(Date requestedStartDate) {
		this.requestedStartDate = requestedStartDate;
	}

	/**
	 * @return the grade
	 */

	public Grade getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	/**
	 * @return the project
	 */

	public Project getProject() {
		return Project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {
		Project = project;
	}

	/**
	 * @return the employee
	 */

	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the sOStatus
	 */
	public SOStatus getSOStatus() {
		return SOStatus;
	}

	/**
	 * @param sOStatus
	 *            the sOStatus to set
	 */
	public void setSOStatus(SOStatus sOStatus) {
		SOStatus = sOStatus;
	}

}
