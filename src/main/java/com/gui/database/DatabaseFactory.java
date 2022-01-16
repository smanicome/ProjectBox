package com.gui.database;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import com.gui.entities.Teacher;

@ApplicationScoped
public class DatabaseFactory {
	
	@PersistenceUnit(unitName = "gui")
    private EntityManagerFactory emf = null;

	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	/*public UserORM getUserORM() {
		return new UserORM( this );
	}*/
	
	/*@Transactional
	public User createUser( String login, String email, String pwd ) {
		User newUser = new User( login, email, pwd );
		emf.persist( newUser );
		emf.flush();
		return newUser;
	}*/
	
	public List<Teacher> getAllUser() {
		EntityManager entityManager = null;
        try {
            entityManager = emf.createEntityManager();
            
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            
            List<Teacher> response = entityManager.createNamedQuery("Teacher.findAll", Teacher.class).getResultList();
            
            transaction.commit();
            
            return response;
        } finally {
            if ( entityManager != null ) entityManager.close();
        }
	}
}
