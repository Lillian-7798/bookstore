package com.reins.bookstore.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderService {
    List<Map> getManagerOrders();
    List<Map> getBuyManagerB(Date start, Date end);
    List<Map> getBuyManagerU(Date start, Date end);
}
