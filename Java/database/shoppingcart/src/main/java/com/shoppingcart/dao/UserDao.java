package com.shoppingcart.dao;

import com.shoppingcart.model.Users;
import java.util.List;

/**
 *
 * @author nihar
 */
public interface UserDao {
    public void create(Users user);
    public Users get(int id);
    public List<Users> getAll();
}
