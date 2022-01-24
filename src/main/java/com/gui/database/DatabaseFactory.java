package com.gui.database;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.gui.adelete.StudentDao;
import com.gui.adelete.StudentDaoInterface;

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

	public ProjectDao getProjectDAO() {
		return new ProjectDao( this );
	}

	public CourseDao getCourseDAO() {
		return new CourseDao( this );
	}
}
