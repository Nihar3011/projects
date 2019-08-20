package com.mycompany.compositekey;

import com.mycompany.compositekey.model.UserProfile;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author nihar
 */
public class DemoMain {


    public static void main(String[] args) {
       EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

        DemoMain.createUser(entityManager);
        JPAUtil.shutdown();
    }
    
    public static void createUser(EntityManager entityManager) {
        
       
        entityManager.getTransaction().begin();
        entityManager.merge(new UserProfile("Nihar ", "npatel@argusof.in", "7985454"));
        entityManager.getTransaction().commit();
        entityManager.close();
       
    }

}
