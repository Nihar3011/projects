package com.mycompany.dao;

import com.mycompany.model.Greetings;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nihar
 */
public class GreetingDao {
    
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Greetings");
    
    EntityManager em = emf.createEntityManager();
    
    public void createHelloWorld(Greetings greetings){
        em.getTransaction().begin();
        em.persist(greetings);
        em.getTransaction().commit();
    }
    
    public Greetings getHelloWorldById(int id){
        em.getTransaction().begin();
        Greetings hw = em.find(Greetings.class, id);
        em.getTransaction().commit();
        return hw;
    }
}
