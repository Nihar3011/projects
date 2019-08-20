package com.shoppingcart.dao;

import com.shoppingcart.model.BankAccount;
import java.util.List;

/**
 *
 * @author nihar
 */
public interface BankAccountDao {
    public void create(int userId,BankAccount bankAccount);
    public BankAccount get(int id);
    public List<BankAccount> getAll();
}
