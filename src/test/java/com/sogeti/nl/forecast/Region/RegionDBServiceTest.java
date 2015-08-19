/**
 * 
 */
package com.sogeti.nl.forecast.Region;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.sogeti.nl.forecast.common.AbstractTest;
import com.sogeti.nl.forecast.db.model.Employee;
import com.sogeti.nl.forecast.db.model.Region;
import com.sogeti.nl.forecast.db.service.RegionDBService;
import com.sogeti.nl.forecast.enums.Billability;
import com.sogeti.nl.forecast.enums.Status;

/**
 * @author takhade
 *
 */
@RunWith(JUnit4.class)
public class RegionDBServiceTest extends AbstractTest{
	
	private RegionDBService regionDBService;
	
	@Before
	public void init() throws Exception{
		
		regionDBService = new RegionDBService();
		regionDBService.setEntityManager(getEntityManager());
		
	}
	
	private Region createRegion(String regionCode,String regionName){
		
		Region region=new Region();
		region.setRegionCode(regionCode);
		region.setRegionName(regionName);
		region.setStatus(Status.active);
		return region;
	}

	@Test
	public void testInsertRegion(){
		
		Region region= createRegion("NL", "Netherland");
		getTransaction().begin();
		regionDBService.persist(region);
		getTransaction().commit();
		Assert.assertNotNull(region.getId());
	}

	@Test
	public void testSearchRegion(){
		
		Region region=createRegion("IN", "India");
		getTransaction().begin();
		regionDBService.persist(region);
		getTransaction().commit();
		region=regionDBService.findByProperty(Region.class,"regionCode" ,"IN" );
		Assert.assertNotNull(region);
	}
	
	@Test
	public void testUpdateRegion(){
		Region region=createRegion("FR", "France");
		getTransaction().begin();
		regionDBService.persist(region);
		getTransaction().commit();
		region=regionDBService.findByProperty(Region.class, "regionCode", "FR");
		region.setRegionName("UK");
		region.setStatus(Status.inactive);
		getTransaction().begin();
		regionDBService.merge(region);
		getTransaction().commit();
		region=regionDBService.findByProperty(Region.class, "regionCode", "FR");
		Assert.assertEquals(region.getRegionName(), "UK");
	}
	
}
