package com.gui.database;

import com.gui.entities.Course;
import com.gui.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.Objects;

@Transactional
public class CourseDao {

	private final EntityManagerFactory emf;

	public CourseDao(DatabaseFactory databaseFactory ) {
		Objects.requireNonNull( databaseFactory );
		this.emf = databaseFactory.getEmf();
	}
	
	private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
	
	public void create( Course course ) {
		Objects.requireNonNull( course );
		
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	EntityTransaction transaction = em.getTransaction();
        	transaction.begin();
        	em.persist( course );
        	transaction.commit();
        } finally {
        	if ( em != null ) em.close();
        }
	}
	
	public Course getCourseByCode(String courseCode ) {
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	return em.createNamedQuery("Course.findByCode", Course.class).setParameter("code", courseCode).getSingleResult();
        } finally {
        	if ( em != null ) em.close();
        }
	}
}
