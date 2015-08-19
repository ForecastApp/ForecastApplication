/**
 * 
 */
package com.sogeti.nl.forecast.employee;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.sogeti.nl.forecast.common.AbstractTest;
import com.sogeti.nl.forecast.db.model.Employee;
import com.sogeti.nl.forecast.db.service.EmployeeDBService;
import com.sogeti.nl.forecast.enums.Billability;
import com.sogeti.nl.forecast.enums.Status;

/**
 * @author takhade
 * 
 *         EmployeeDBServiceTest class extends AbstractTest class
 */
@RunWith(JUnit4.class)
public class EmployeeDBServiceTest extends AbstractTest {

	private EmployeeDBService employeeDBService;

	@Before
	public void setUp() {

		employeeDBService = new EmployeeDBService();
		employeeDBService.setEntityManager(getEntityManager());
		getTransaction().begin();

	}

	@After
	public void teardown() {
		if (getTransaction().isActive()) {
			getTransaction().rollback();
		}
	}

	private Employee createEmployee(String firstName, String lastName,
			int employeeId) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmployeeId(employeeId);
		employee.setBillability(Billability.billable);
		employee.setStatus(Status.active);
		employee.setReleaseDate(new Date());
		return employee;
	}

	@Test
	public void testInsertEmployee() {

		Employee employee = createEmployee("Trushana", "Akhade", 12345);
		employeeDBService.persist(employee);
		Assert.assertNotNull(employee.getId());
	}

	@Test
	public void testSearchEmployee() {

		Employee employee = createEmployee("Shweta", "Dhotre", 23456);
		employeeDBService.persist(employee);
		employee = employeeDBService.findByProperty(Employee.class,
				"employeeId", 23456);
		Assert.assertNotNull(employee);
	}

	@Test
	public void testUpdateEmployee() {

		Employee employee = createEmployee("Test", "Test", 34567);
		employeeDBService.persist(employee);
		employee = employeeDBService.findByProperty(Employee.class,
				"employeeId", 34567);
		employee.setFirstName("Shweta");
		employee.setLastName("Dhotre");
		employee.setBillability(Billability.billable);
		employee.setStatus(Status.active);
		employee.setReleaseDate(new Date());
		employeeDBService.merge(employee);
		employee = employeeDBService.findByProperty(Employee.class,
				"employeeId", 34567);
		Assert.assertEquals(employee.getFirstName(), "Shweta");
	}
}
