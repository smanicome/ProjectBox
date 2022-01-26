package com.gui.database;

import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import com.gui.entities.Ip;

/**
 * Accessing courses data from database
 */
@Transactional
public class IpDao implements IpDaoInterface{
	
	private final EntityManagerFactory emf;

	/**
	 * create connection
	 * @param databaseFactory, DatabaseFactory type
	 */
	IpDao( DatabaseFactory databaseFactory ) {
		Objects.requireNonNull( databaseFactory );
		this.emf = databaseFactory.getEmf();
	}
	
	/**
	 * Get Entity Manager
	 */
	private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


	/**
	 * create new transaction given a certain ip
	 * @param ip
	 */
	@Override
	public void create(Ip ip) {
		Objects.requireNonNull( ip );
		
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	EntityTransaction transaction = em.getTransaction();
        	transaction.begin();
        	em.persist( ip );
        	transaction.commit();
        } finally {
        	if ( em != null ) em.close();
        }
		
	}

}
