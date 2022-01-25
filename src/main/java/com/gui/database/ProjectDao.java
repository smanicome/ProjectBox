package com.gui.database;

import com.gui.entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Accessing project data from database
 */
@Transactional
public class ProjectDao implements ProjectDaoInterface {

	private final EntityManagerFactory emf;

	/**
	 * Create connection
	 * @param databaseFactory, DatabaseFactory type
	 */
	ProjectDao(DatabaseFactory databaseFactory ) {
		Objects.requireNonNull( databaseFactory );
		this.emf = databaseFactory.getEmf();
	}

	/**
	 * Get entity manager
	 */
	
	private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

	/**
	 * Create new transaction given a certain project
	 * @param project
	 */
	@Override
	public void create( Project project ) {
		Objects.requireNonNull( project );
		
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	EntityTransaction transation = em.getTransaction();
        	transation.begin();
        	em.persist( project );
        	transation.commit();
        } finally {
        	if ( em != null ) em.close();
        }
	}

	/**
	 * Retrive List of projects taken a certain course code
	 * @param courseId
	 * @return
	 */
	@Override
	public List<Project> getProjectsByCourse( int courseId ) {
		if ( courseId <= 0 ) throw new IllegalArgumentException();
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	return em.createNamedQuery("Project.findByCourse", Project.class).setParameter("courseId", courseId).getResultStream().collect(Collectors.toList());
        } finally {
        	if ( em != null ) em.close();
        }
	}
}
