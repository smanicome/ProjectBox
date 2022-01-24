package com.gui.database;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.gui.entities.User;

class UserDao implements UserDaoInterface {
	
	private final EntityManagerFactory emf;
	
	UserDao( DatabaseFactory factory ) {
		Objects.requireNonNull( factory );
		
		this.emf = factory.getEmf();
	}
	
	private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

	@Override
	public Optional<User> getUser( String email, String password ) {
		Objects.requireNonNull( email );
		Objects.requireNonNull( password );
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	return em.createNamedQuery("User.login", User.class).setParameter("email", email).setParameter("password", password).getResultStream().findFirst();
        } finally {
        	if ( em != null ) em.close();
        }
	}

	@Override
	public List<User> getUsers() {
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	return em.createNamedQuery("User.list", User.class).getResultList();
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
