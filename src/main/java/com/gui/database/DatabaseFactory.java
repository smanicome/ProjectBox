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
	
	public UserORM getUserORM() {
		return new UserORM( this );
	}
}
