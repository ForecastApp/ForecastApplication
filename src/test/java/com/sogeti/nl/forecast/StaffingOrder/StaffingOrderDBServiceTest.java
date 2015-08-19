/**
 * 
 */
package com.sogeti.nl.forecast.StaffingOrder;

/**
 * 
 */

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.sogeti.nl.forecast.common.AbstractTest;
import com.sogeti.nl.forecast.db.model.StaffingOrder;
import com.sogeti.nl.forecast.db.service.StaffingOrderDBService;
import com.sogeti.nl.forecast.enums.SOStatus;

/**
 * @author takhade
 * 
 *         StaffingOrderDBServiceTest class extends AbstractTest class
 *
 */
@RunWith(JUnit4.class)
public class StaffingOrderDBServiceTest extends AbstractTest {

	private StaffingOrderDBService staffingOrderDBService;

	@Before
	public void setUp() {

		staffingOrderDBService = new StaffingOrderDBService();
		staffingOrderDBService.setEntityManager(getEntityManager());
		getTransaction().begin();

	}

	@After
	public void teardown() {
		if (getTransaction().isActive()) {
			getTransaction().rollback();
		}
	}

	private StaffingOrder createStaffingOrder(String soReferenceNumber,
			Date date) {
		StaffingOrder staffingOrder = new StaffingOrder();
		staffingOrder.setSoReferenceNo(soReferenceNumber);
		staffingOrder.setSOStatus(SOStatus.open);
		staffingOrder.setRequestedStartDate(date);
		return staffingOrder;
	}

	@Test
	public void testInsertStaffingOrder() {

		StaffingOrder staffingOrder = createStaffingOrder("SO1234", new Date());
		staffingOrderDBService.persist(staffingOrder);
		Assert.assertNotNull(staffingOrder.getId());

	}

	@Test
	public void testSearchStaffingOrder() {

		StaffingOrder staffingOrder = createStaffingOrder("SO9876", new Date());
		staffingOrderDBService.persist(staffingOrder);
		staffingOrder = staffingOrderDBService.findByProperty(
				StaffingOrder.class, "soReferenceNo", "SO9876");
		Assert.assertNotNull(staffingOrder);
	}

	@Test
	public void testUpdateStaffingOrder() {

		StaffingOrder staffingOrder = createStaffingOrder("SO3456", new Date());
		staffingOrderDBService.persist(staffingOrder);
		staffingOrder = staffingOrderDBService.findByProperty(
				StaffingOrder.class, "soReferenceNo", "SO3456");
		staffingOrder.setSOStatus(SOStatus.cancelled);
		staffingOrderDBService.merge(staffingOrder);
		staffingOrder = staffingOrderDBService.findByProperty(
				StaffingOrder.class, "soReferenceNo", "SO3456");
		Assert.assertEquals(staffingOrder.getSOStatus(), SOStatus.cancelled);
	}
}
