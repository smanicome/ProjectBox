package com.gui.database;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.gui.entities.User;

/**
 * Accessing user data from database
 */
class UserDao implements UserDaoInterface {
	
	private final EntityManagerFactory emf;

	/**
	 * Create connection
	 * @param factory, DatabaseFactory type
	 */
	UserDao( DatabaseFactory factory ) {
		Objects.requireNonNull( factory );
		
		this.emf = factory.getEmf();
	}

	/**
	 * get entity manager
	 */
	private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

	/**
	 * Get user given its email and password
	 * @param email, String
	 * @param password, String
	 * @return User
	 */
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

	/**
	 * Retrive user from database given a certain user ID
	 * @param id, int
	 * @return User
	 */
	@Override
	public Optional<User> getUserById(int id) {
		if ( id <= 0 ) throw new IllegalArgumentException();
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	return em.createNamedQuery("User.findByid", User.class).setParameter("id", id).getResultStream().findFirst();
        } finally {
        	if ( em != null ) em.close();
        }
	}

	/**
	 * Retrive all users
	 * @return List<User>
	 */
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

	/**
	 * Create new user in database
	 * @param user
	 */

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

	/**
	 * Update user in database
	 * @param user
	 */

	@Override
	public void update(User user) {
		Objects.requireNonNull( user );
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	EntityTransaction transation = em.getTransaction();
        	transation.begin();
        	em.merge(user);
        	transation.commit();
        } finally {
        	if ( em != null ) em.close();
        }
	}
}
