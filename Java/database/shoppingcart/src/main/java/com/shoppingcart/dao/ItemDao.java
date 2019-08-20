package com.shoppingcart.dao;

import com.shoppingcart.model.Item;
import java.util.List;

/**
 *
 * @author nihar
 */
public interface ItemDao {
    public void create(int sallerId, Item item);
    public Item get(int id);
    public List<Item> getAll();
}
