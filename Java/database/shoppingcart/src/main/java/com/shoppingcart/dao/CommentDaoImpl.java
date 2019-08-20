package com.shoppingcart.dao;

import com.shoppingcart.model.Comment;
import com.shoppingcart.model.Item;
import com.shoppingcart.model.Users;
import com.shoppingcart.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author nihar
 */
public class CommentDaoImpl implements CommentDao {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public void create(int userId, int itemId, Comment comment) {
        try {
            entityManager.getTransaction().begin();
            comment.setUser(entityManager.find(Users.class, userId));
            comment.setItem(entityManager.find(Item.class, userId));
            entityManager.persist(comment);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        }
    }

    @Override
    public Comment get(int id) {
        Comment comment = null;
        try {
            comment = entityManager.find(Comment.class, id);
        } catch (Exception e) {
        }
        return comment;
    }

    @Override
    public List<Comment> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
