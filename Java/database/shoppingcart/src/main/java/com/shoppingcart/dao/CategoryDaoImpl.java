package com.shoppingcart.dao;

import com.shoppingcart.model.Category;
import com.shoppingcart.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author nihar
 */
public class CategoryDaoImpl implements CategoryDao {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void create(Category category) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(category);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Category get(int id) {
        Category category = null;
        try {
            category = entityManager.find(Category.class, id);
        } catch (Exception e) {
        }
        return category;
    }

    @Override
    public List<Category> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
