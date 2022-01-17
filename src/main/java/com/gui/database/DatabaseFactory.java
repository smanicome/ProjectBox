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

	public UserORM getUserORM() {
		return new UserORM( this );
	}
	public TeacherDAO getTeacherDAO() {
		return new TeacherDAO( this );
	}
}
