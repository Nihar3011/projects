package com.shoppingcart.dao;

import com.shoppingcart.model.Bid;
import com.shoppingcart.model.Item;
import com.shoppingcart.model.Users;
import com.shoppingcart.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author nihar
 */
public class BidDaoImpl implements BidDao {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void create(int userId, int itemId, Bid bid) {
        try {
            entityManager.getTransaction().begin();
            bid.setBuyer(entityManager.find(Users.class, userId));
            bid.setItem_id(entityManager.find(Item.class, itemId));
            entityManager.persist(bid);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Bid get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bid> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
