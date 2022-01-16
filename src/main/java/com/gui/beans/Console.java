package com.gui.beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gui.entities.Teacher;

public class Console {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("gui");
            entityManager = entityManagerFactory.createEntityManager();
            
            //par rapport a l'id
            Teacher user = entityManager.find(Teacher.class, "tito");
            System.out.println( user );
        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
	}

}
