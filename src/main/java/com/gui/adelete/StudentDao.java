package com.gui.adelete;

import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.gui.database.DatabaseFactory;

public class StudentDao implements StudentDaoInterface {
	
	private EntityManagerFactory emf;
	
	StudentDao( DatabaseFactory factory ) {
		Objects.requireNonNull( factory );
		
		//this.emf = factory.getEmf();
	}
	
	private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
	
	private void transaction(Student student) {
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	EntityTransaction transation = em.getTransaction();
        	transation.begin();
        	em.persist( student );
        	transation.commit();
        } finally {
        	if ( em != null ) em.close();
        }
	}

	@Override
	public Optional<Student> getStudent(String email, String password) {
		Objects.requireNonNull( email );
		Objects.requireNonNull( password );
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	return em.createNamedQuery("Student.auth", Student.class).setParameter("email", email).setParameter("password", password).getResultStream().findFirst();
        } finally {
        	if ( em != null ) em.close();
        }
	}
	
	@Override
	public void create(Student student) {
		Objects.requireNonNull( student );
		
		transaction( student );
	}
	
	@Override
	public void update(Student student) {
		Objects.requireNonNull( student );
		
		transaction( student );
	}

}
