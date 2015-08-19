/**
 * 
 */
package com.sogeti.nl.forecast.project;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.sogeti.nl.forecast.common.AbstractTest;
import com.sogeti.nl.forecast.db.model.Project;
import com.sogeti.nl.forecast.db.service.ProjectDBService;
import com.sogeti.nl.forecast.enums.Status;

/**
 * @author takhade
 * 
 *         ProjectDBServiceTest class extends AbstractTest class
 * 
 *
 */
@RunWith(JUnit4.class)
public class ProjectDBServiceTest extends AbstractTest {

	private ProjectDBService projectDBService;

	@Before
	public void setUp() {

		projectDBService = new ProjectDBService();
		projectDBService.setEntityManager(getEntityManager());
		getTransaction().begin();

	}

	@After
	public void teardown() {
		if (getTransaction().isActive()) {
			getTransaction().rollback();
		}
	}

	private Project createProject(int projectCode, String projectName) {

		Project project = new Project();
		project.setProjectCode(projectCode);
		project.setProjectName(projectName);
		project.setStatus(Status.active);
		return project;

	}

	@Test
	public void testInsertProject() {

		Project project = createProject(123454, "Digilevering");
		projectDBService.persist(project);
		Assert.assertNotNull(project.getId());

	}

	@Test
	public void testSearchProject() {

		Project project = createProject(34567, "ForecastApp");
		projectDBService.persist(project);
		project = projectDBService.findByProperty(Project.class, "projectCode",
				34567);
		Assert.assertNotNull(project);

	}

	@Test
	public void testUpdateProject() {
		Project project = createProject(56789, "UMDashboard");
		projectDBService.persist(project);
		project = projectDBService.findByProperty(Project.class, "projectCode",
				56789);

		project.setProjectName("NS HighSpeed");
		project.setStatus(Status.inactive);
		projectDBService.merge(project);
		project = projectDBService.findByProperty(Project.class, "projectCode",
				56789);
		Assert.assertEquals(project.getProjectName(), "NS HighSpeed");

	}

}
