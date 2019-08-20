package com.shoppingcart.dao;

import com.shoppingcart.model.CreditCard;
import java.util.List;

/**
 *
 * @author nihar
 */
public interface CreditCardDao {
    public void create(int userId,CreditCard creditCard);
    public CreditCard get(int id);
    public List<CreditCard> getAll();
}
