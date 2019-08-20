package com.shoppingcart.dao;

import com.shoppingcart.model.Category;
import java.util.List;

/**
 *
 * @author nihar
 */
public interface CategoryDao {
    public void create(Category category);
    public Category get(int id);
    public List<Category> getAll();
}
