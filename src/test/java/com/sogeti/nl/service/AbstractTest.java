
package com.sogeti.nl.service;

/**
 * @author takhade
 *
 */

import static org.junit.Assert.assertTrue;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;




import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.sogeti.nl.model.So;



/**
* AbstrastTest class for all the ServiceTest classes. Every ServiceTest class
* with extends this class.
* 
 * @version $Id:$
* @author 9308462 (c) Dec 17, 2013, Sogeti B.V.
*/
public abstract class AbstractTest {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private CrudService crudService;
 

    @BeforeClass
    public static void initEntityManagerFactory() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("manager");
    }

    @AfterClass
    public static void closeEntityManagerFactory() throws Exception {
        entityManagerFactory.close();
    }

    @Before
    public void setupEntityManager() throws Exception {
        this.entityManager = entityManagerFactory.createEntityManager();
        this.transaction = this.entityManager.getTransaction();
    }

    @After
    public void closeEntityManager() throws Exception {
        this.entityManager.close();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public EntityTransaction getTransaction() {
        return this.transaction;
    }

    

    /**
     * generic method to persist data for JUnit database models. this method wil
     * first check if the entity already exists in the persistence scope. if
     * yes, it returns the same object else its invokes persists on CrudService
     * and returns the persisted object. NOTE: all the entity models should
     * extends AbstractBaseEntity somewhere in the hierarchy
     * 
     * @param en
     *            - a AbstractBaseEntity which hold entity that needs to be
     *            persisted.
     * @return - a AbstractBaseEntity which holds the persisted entity model.
     */
        /*protected So persist(So en){
    	if(crudService.getEntityManager().contains(en)){
    		return en;
    	}
    	try{
    		if(en instanceof So){
    			
    		}
    		en = crudService.persist(en);
    	}
    	catch (Exception e) {
            e.printStackTrace();
            assertTrue("DataException in method  persist(). " + e.getMessage(), Boolean.FALSE);
        }
		return en;
    	
    }*/
    /**
     * Set the CrudService to the specified value.
     * 
     * @param CrudService
     *            The CrudService to set.
     */
   
	public void setCrudService(CrudService crudService) {
		this.crudService = crudService;
	}

}
