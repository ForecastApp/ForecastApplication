/**
 * 
 */
package com.sogeti.nl.forecast.Region;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.sogeti.nl.forecast.common.AbstractTest;
import com.sogeti.nl.forecast.db.model.Region;
import com.sogeti.nl.forecast.db.service.RegionDBService;
import com.sogeti.nl.forecast.enums.Status;

/**
 * @author takhade
 * 
 *         RegionDBServiceTest class extends AbstractTest class
 *
 */
@RunWith(JUnit4.class)
public class RegionDBServiceTest extends AbstractTest {

	private RegionDBService regionDBService;

	@Before
	public void setUp() {

		regionDBService = new RegionDBService();
		regionDBService.setEntityManager(getEntityManager());
		getTransaction().begin();

	}

	@After
	public void teardown() {
		if (getTransaction().isActive()) {
			getTransaction().rollback();
		}
	}

	private Region createRegion(String regionCode, String regionName) {

		Region region = new Region();
		region.setRegionCode(regionCode);
		region.setRegionName(regionName);
		region.setStatus(Status.active);
		return region;
	}

	@Test
	public void testInsertRegion() {

		Region region = createRegion("NL", "Netherland");
		regionDBService.persist(region);
		Assert.assertNotNull(region.getId());
	}

	@Test
	public void testSearchRegion() {

		Region region = createRegion("IN", "India");
		regionDBService.persist(region);
		region = regionDBService.findByProperty(Region.class, "regionCode",
				"IN");
		Assert.assertNotNull(region);
	}

	@Test
	public void testUpdateRegion() {
		Region region = createRegion("FR", "France");
		regionDBService.persist(region);
		region = regionDBService.findByProperty(Region.class, "regionCode",
				"FR");
		region.setRegionName("UK");
		region.setStatus(Status.inactive);
		regionDBService.merge(region);
		region = regionDBService.findByProperty(Region.class, "regionCode",
				"FR");
		Assert.assertEquals(region.getRegionName(), "UK");
	}

}
