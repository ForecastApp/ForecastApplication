/**
 * 
 */
package com.sogeti.nl.forecast.db.service;

import com.sogeti.nl.forecast.db.model.Employee;

/**
 * @author takhade
 *
 */
public class EmployeeDBService extends CrudService {

	public Employee persist(Employee employee) {
		getEntityManager().persist(employee);
		return employee;
	}

}
