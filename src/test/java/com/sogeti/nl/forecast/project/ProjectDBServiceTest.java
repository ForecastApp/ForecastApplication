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
import com.sogeti.nl.forecast.enums.Status;

/**
 * @author takhade
 *
 */
@RunWith(JUnit4.class)
public class ProjectDBServiceTest extends AbstractTest {

	private ProjectDBService projectDBService;

	@Before
	public void init() throws Exception {

		projectDBService = new ProjectDBService();
		projectDBService.setEntityManager(getEntityManager());
	}

	public void insertProject(){
		
	}
	
	
	@Test
	public void testInsertProject() {

		Project project = new Project();
		project.setProjectCode(112300);
		project.setProjectName("Digilevering");
		project.setStatus(Status.active);
		getTransaction().begin();
		projectDBService.persist(project);
		getTransaction().commit();
		Assert.assertNotNull(project.getId());

	}
	
	public void testSearchProject(){
		
	}

	
}
