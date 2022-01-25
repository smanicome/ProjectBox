package com.gui.database;

import com.gui.entities.Course;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.Objects;

/**
 * Accessing courses data from database
 */
@Transactional
class CourseDao implements CourseDaoInterface {

	private final EntityManagerFactory emf;

	/**
	 * create connection
	 * @param databaseFactory, DatabaseFactory type
	 */
	CourseDao(DatabaseFactory databaseFactory ) {
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
	 *create new transaction given a certain course
	 * @param course
	 */
	@Override
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

	/**
	 * Get wanted course by filtering it with its code
	 * @param courseCode, String
	 * @return
	 */
	public Course getCourseByCode(String courseCode) {
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	return em.createNamedQuery("Course.findByCode", Course.class).setParameter("code", courseCode).getSingleResult();
        } finally {
        	if ( em != null ) em.close();
        }
	}
}
