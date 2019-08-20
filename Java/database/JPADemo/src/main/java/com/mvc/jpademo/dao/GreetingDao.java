package com.mvc.jpademo.dao;

import com.mvc.jpademo.main.JPAUtil;
import com.mvc.jpademo.model.Greetings;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author nihar
 */
public class GreetingDao {
         
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

  
    public void createHelloWorld(Greetings greetings){
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Greetings helloworld = new Greetings("Hello World!!!");

        entityManager.merge(helloworld);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public Greetings getHelloWorldById(int id){
        entityManager.getTransaction().begin();
        Greetings hw = entityManager.find(Greetings.class, id);
        entityManager.getTransaction().commit();
        return hw;
    }
}
