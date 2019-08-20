package com.shoppingcart.dao;

import com.shoppingcart.model.Comment;
import java.util.List;

/**
 *
 * @author nihar
 */
public interface CommentDao {
    public void create(int userId, int itemId, Comment comment);
    public Comment get(int id);
    public List<Comment> getAll();
}
