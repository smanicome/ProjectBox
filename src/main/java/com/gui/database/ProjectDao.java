package com.gui.database;

import com.gui.entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Transactional
public class ProjectDao {

	private final EntityManagerFactory emf;

	public ProjectDao(DatabaseFactory databaseFactory ) {
		Objects.requireNonNull( databaseFactory );
		this.emf = databaseFactory.getEmf();
	}
	
	private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
	
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
	
	public List<Project> getProjectsByCourse(String courseId ) {
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	return em.createNamedQuery("Project.findByCourse", Project.class).setParameter("courseId", courseId).getResultStream().collect(Collectors.toList());
        } finally {
        	if ( em != null ) em.close();
        }
	}
}
