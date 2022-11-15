package com.reins.bookstore.service;

import com.reins.bookstore.entity.Users;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UsersService {
    Map checkUser(String username, String password);

    long Logout();
    boolean Register(String username,String password);

    Integer getType(int userid);
    Integer getUserState(int userid);
    List<Map> getUsers();
    boolean changeState(int uid);
    boolean checkDup(String username);
    List<Map> getOrders(Integer uid);
    List<Map> getBuyID(Integer uid, Date start, Date end);
}
