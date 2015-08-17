/**
 * 
 */
package com.sogeti.nl.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author takhade
 *
 */
@RunWith(JUnit4.class)
public class SoServiceTest extends AbstractTest  {
	
	
/*	private EntityManagerFactory emFactory;

    private EntityManager em;

	
	
	@Before
	public void setUp() throws Exception{
		
		
	}
	
	@After
	public void tearDown() throws Exception
	{
		
	}
	
	@Test
	public void testPersistence()
	{
		
		try{
			getEntityManager().getTransaction().begin();
		
			So so=new So();
			so.setSoreferenceno("SATest");
			so.setId(1);
			
			getEntityManager().persist(so);
			
			Assert.assertNotNull(so);
			Assert.assertTrue(getEntityManager().contains(so));

			
		}
		catch (Exception ex) {
			getEntityManager().getTransaction().rollback();
            ex.printStackTrace();
           
        }
		
	}*/
	
	@Test
	public void simpleTest(){
		System.out.println("success");
	}

}
