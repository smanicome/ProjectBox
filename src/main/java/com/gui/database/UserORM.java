package com.gui.database;

import com.gui.entities.User;

import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class UserORM {
	
	private final EntityManagerFactory emf;

	public UserORM( DatabaseFactory databaseFactory ) {
		Objects.requireNonNull( databaseFactory );
		this.emf = databaseFactory.getEmf();
	}
	
	private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
	
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
	
	public Optional<User> getUser( String email ) {
		EntityManager em = null;
        try {
        	em = this.getEntityManager();
        	return em.createNamedQuery("User.login", User.class).setParameter("email", email).getResultStream().findFirst();
        } finally {
        	if ( em != null ) em.close();
        }
	}
	
	/*public void getUser() {
		EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Writer.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
        	if ( em != null ) em.close();
        }
	}*/
}
