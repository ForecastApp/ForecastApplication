package com.sogeti.nl.forecast.common;

/**
 * @author takhade
 *
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * AbstrastTest class for all the ServiceTest classes. Every ServiceTest class
 * with extends this class.
 * 
 */
public abstract class AbstractTest {

	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;

	@BeforeClass
	public static void initEntityManagerFactory() throws Exception {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("manager");
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
}
