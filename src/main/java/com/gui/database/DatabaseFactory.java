package com.gui.database;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class DatabaseFactory {
	@PersistenceUnit(unitName = "gui")
    private EntityManagerFactory emf = null;

	EntityManagerFactory getEmf() {
		return emf;
	}

	public UserDaoInterface getUserDAO() {
		return new UserDao( this );
	}

	public ProjectDaoInterface getProjectDAO() {
		return new ProjectDao( this );
	}

	public CourseDaoInterface getCourseDAO() {
		return new CourseDao( this );
	}
}
