package com.reins.bookstore.dao;


import com.reins.bookstore.entity.OrderItem;
import com.reins.bookstore.entity.Orders;
import com.reins.bookstore.entity.Users;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderDao {
    List<Map> getManagerOrders();
    List<Map> getBuyManagerB(Date start, Date end);
    List<Map> getBuyManagerU(Date start, Date end);
    Orders setOrder(String address,Integer userid);
}
