package com.gui.database;

import com.gui.entities.Course;
import com.gui.entities.Teacher;
import com.gui.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Transactional
public class TeacherDAO {

	private final EntityManagerFactory emf;

	public TeacherDAO(DatabaseFactory databaseFactory ) {
		Objects.requireNonNull( databaseFactory );
		this.emf = databaseFactory.getEmf();
	}
	
	private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
	
	public void create( Teacher teacher ) {
		Objects.requireNonNull( teacher );
		
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	EntityTransaction transation = em.getTransaction();
        	transation.begin();
        	em.persist( teacher );
        	transation.commit();
        } finally {
        	if ( em != null ) em.close();
        }
	}
	
	public Optional<Teacher> getTeacherById( int id ) {
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	return em.createNamedQuery("Teacher.findById", Teacher.class).setParameter("id", id).getResultStream().findFirst();
        } finally {
        	if ( em != null ) em.close();
        }
	}
}
