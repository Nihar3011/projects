package com.shoppingcart.dao;

import com.shoppingcart.model.Bid;
import java.util.List;

/**
 *
 * @author nihar
 */
public interface BidDao {
    public void create(int userId, int itemId, Bid bid);
    public Bid get(int id);
    public List<Bid> getAll();
}
