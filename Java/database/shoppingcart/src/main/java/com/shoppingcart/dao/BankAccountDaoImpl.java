package com.shoppingcart.dao;

import com.shoppingcart.model.BankAccount;
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
public class BankAccountDaoImpl implements BankAccountDao {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void create(int userId,BankAccount bankAccount) {
        try {
            entityManager.getTransaction().begin();
            bankAccount.setUser(entityManager.find(Users.class, userId));
            entityManager.persist(bankAccount);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public BankAccount get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public List<BankAccount> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
