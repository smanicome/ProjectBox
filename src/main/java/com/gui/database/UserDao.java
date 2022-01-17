package com.gui.database;

import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.gui.entities.User;

public class UserDao implements UserDaoInterface{
	
	private final EntityManagerFactory emf;
	
	UserDao( DatabaseFactory factory ) {
		Objects.requireNonNull( factory );
		
		this.emf = factory.getEmf();
	}
	
	private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

	@Override
	public Optional<User> getUser( String email ) {
		Objects.requireNonNull( email );
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	return em.createNamedQuery("User.login", User.class).setParameter("email", email).getResultStream().findFirst();
        } finally {
        	if ( em != null ) em.close();
        }
	}
	
	@Override
	public void create( User user ) {
		Objects.requireNonNull( user );
		
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	EntityTransaction transation = em.getTransaction();
        	transation.begin();
        	em.persist( user );
        	transation.commit();
        } finally {
        	if ( em != null ) em.close();
        }
	}

}
