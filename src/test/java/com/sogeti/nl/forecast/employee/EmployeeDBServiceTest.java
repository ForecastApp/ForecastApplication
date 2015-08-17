/**
 * 
 */
package com.sogeti.nl.forecast.employee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sogeti.nl.forecast.common.AbstractTest;
import com.sogeti.nl.forecast.db.model.Employee;
import com.sogeti.nl.forecast.db.service.EmployeeDBService;

/**
 * @author takhade
 *
 */
public class EmployeeDBServiceTest extends AbstractTest {

	private EmployeeDBService employeeDBService;

	Employee employee = new Employee();

	@Before
	public void init() throws Exception {
		this.employeeDBService = new EmployeeDBService();

	}

	@Test
	public void testInsert() {

		employee.setFirstName("Trushana");
		employee.setLastName("Akhade");
		employee.setEmployeeId(60683);
		getTransaction().begin();
		getEntityManager().persist(employee);
		getTransaction().commit();
		Assert.assertNotNull(employee.getId());

	}

}
