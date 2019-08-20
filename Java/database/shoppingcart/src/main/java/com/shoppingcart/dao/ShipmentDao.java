package com.shoppingcart.dao;

import com.shoppingcart.model.Shipment;
import java.util.List;

/**
 *
 * @author nihar
 */
public interface ShipmentDao {
    public void create(int itemId, int buyerId, int sallerId, int addresId, Shipment shipment);
    public Shipment get(int id);
    public List<Shipment> getAll();
}
