package com.gui.database;

import com.gui.entities.Teacher;

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
	public TeacherDAO getTeacherDAO() {
		return new TeacherDAO( this );
	}
	
	public StudentDaoInterface getStudentDAO() {
		return new StudentDao( this );
	}

	public ProjectDAO getProjectDAO() {
		return new ProjectDAO( this );
	}
}
