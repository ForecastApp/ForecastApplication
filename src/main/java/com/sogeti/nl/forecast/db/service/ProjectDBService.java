/**
 * 
 */
package com.sogeti.nl.forecast.db.service;

import javax.ejb.Stateless;

import com.sogeti.nl.forecast.db.model.Project;

/**
 * @author takhade
 *
 */
@Stateless
public class ProjectDBService extends CrudService {

	public Project persist(Project project) {
		getEntityManager().persist(project);
		return project;

	}

}
