package com.gui.database;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.gui.adelete.StudentDao;
import com.gui.adelete.StudentDaoInterface;
import com.gui.adelete.Teacher;
import com.gui.adelete.TeacherDAO;

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

	public ProjectDAO getProjectDAO() {
		return new ProjectDAO( this );
	}
}
