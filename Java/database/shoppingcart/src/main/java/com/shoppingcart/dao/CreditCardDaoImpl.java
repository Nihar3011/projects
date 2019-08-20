package com.shoppingcart.dao;

import com.shoppingcart.model.Category;
import com.shoppingcart.model.CreditCard;
import com.shoppingcart.model.Users;
import com.shoppingcart.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author nihar
 */
public class CreditCardDaoImpl implements CreditCardDao {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void create(int userId,CreditCard creditCard) {
        try {
            entityManager.getTransaction().begin();
            creditCard.setUser(entityManager.find(Users.class, userId));
            entityManager.persist(creditCard);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public CreditCard get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public List<CreditCard> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
