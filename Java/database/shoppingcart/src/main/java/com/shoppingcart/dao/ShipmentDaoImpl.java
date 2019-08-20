package com.shoppingcart.dao;

import com.shoppingcart.model.Address;
import com.shoppingcart.model.Item;
import com.shoppingcart.model.Shipment;
import com.shoppingcart.model.Users;
import com.shoppingcart.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author nihar
 */
public class ShipmentDaoImpl implements ShipmentDao{

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();
    
    @Override
    public void create(int itemId, int buyerId, int sallerId, int addresId, Shipment shipment) {
        try {
            entityManager.getTransaction().begin();
            shipment.setItem_id(entityManager.find(Item.class, itemId));
            shipment.setSeller(entityManager.find(Users.class, sallerId));
            shipment.setBuyer(entityManager.find(Users.class, buyerId));
            shipment.setDilivery(entityManager.find(Address.class, addresId));
            entityManager.persist(shipment);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Shipment get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Shipment> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
