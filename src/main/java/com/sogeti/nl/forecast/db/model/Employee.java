package com.sogeti.nl.forecast.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sogeti.nl.forecast.enums.Billability;
import com.sogeti.nl.forecast.enums.Status;

/**
 * 
 */

/**
 * @author takhade
 *
 */
@Entity
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2406710590232126120L;

	@Id
	@Column(name = "Id", length = 6)
	@GeneratedValue
	private Integer id;

	@Column(name = "Employee_Id", length = 6)
	private Integer employeeId;

	@Column(name = "First_Name", length = 30)
	private String firstName;

	@Column(name = "Last_Name", length = 30)
	private String lastName;

	@Column(name = "Release_Date")
	private Date releaseDate;

	/**
	 * Foreign Key constraint id
	 */
	@OneToOne
	@JoinColumn(name = "project_Code", nullable = true)
	private Project project;

	@Column(name = "Status", length = 10)
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@Column(name = "Billability", length = 15)
	@Enumerated(EnumType.ORDINAL)
	private Billability billability;

	public Employee() {
	}

	/**
	 * @param id
	 * @param employeeId
	 * @param firstName
	 * @param lastName
	 * @param releaseDate
	 * @param project
	 * @param status
	 * @param billability
	 */
	public Employee(Integer id, Integer employeeId, String firstName,
			String lastName, Date releaseDate, Project project, Status status,
			Billability billability) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.releaseDate = releaseDate;
		this.project = project;
		this.status = status;
		this.billability = billability;
	}

	/**
	 * Primary Key for Employee
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Primary Key for Employee
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return the employeeId
	 */

	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 *
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Employee First Name
	 * 
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Employee First Name
	 * 
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Employee last Name
	 * 
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Employee last Name
	 * 
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Release date for Employee
	 * 
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * Release date for Employee
	 * 
	 * @param releaseDate
	 *            the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the project
	 */

	public Project getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the billability
	 */
	public Billability getBillability() {
		return billability;
	}

	/**
	 * @param billability
	 *            the billability to set
	 */
	public void setBillability(Billability billability) {
		this.billability = billability;
	}

}
