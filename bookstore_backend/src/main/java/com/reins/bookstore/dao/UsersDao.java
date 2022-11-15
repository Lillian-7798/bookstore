package com.reins.bookstore.dao;

import com.reins.bookstore.entity.Users;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UsersDao {
    Map checkUser(String username, String password);

    boolean Register(String username,String password);

    Integer getType(int userid);

    Integer getUserState(int userid);

    List<Map> getUsers();

    boolean changeState(int uid);

    boolean checkDup(String username);

    List<Map> getOrders(Integer uid);
    List<Map> getBuyID(Integer uid, Date start, Date end);
}
