/**
 * 
 */
package com.sogeti.nl.forecast.project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.sogeti.nl.forecast.common.AbstractTest;
import com.sogeti.nl.forecast.db.model.Project;
import com.sogeti.nl.forecast.db.service.ProjectDBService;

/**
 * @author takhade
 *
 */
@RunWith(JUnit4.class)
public class ProjectDBServiceTest extends AbstractTest {

	private ProjectDBService projectDBService;

	Project project = new Project();

	@Before
	public void init() throws Exception {

		this.projectDBService = new ProjectDBService();
	}

	@Test
	public void testInsert() {

		project.setProjectCode(112300);
		project.setProjectName("Digilevering");
		getTransaction().begin();
		getEntityManager().persist(project);
		getTransaction().commit();
		Assert.assertNotNull(project.getId());

	}

	@Test
	public void testUpdate() {
		project.setProjectCode(12390);
		project.setProjectName("UmDashboard");
		getTransaction().begin();

	}

}
