package com.shoppingcart.dao;

import com.shoppingcart.model.Users;
import com.shoppingcart.util.EntityManagerUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author nihar
 */
public class UserDaoImpl implements UserDao{

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();
    
    @Override
    public void create(Users user) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Users get(int id) {
        Users person = null;
        try {
            person = entityManager.find(Users.class, id);
        } catch (Exception e) {
        }
        return person;
    }

    @Override
    public List<Users> getAll() {
       List<Users> users=new ArrayList<>();
        try {
         Query query= entityManager.createQuery("from Users",Users.class);
         users= query.getResultList();
        } catch (Exception e) {
        }
     return users;
    }
}
