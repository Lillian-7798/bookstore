package com.reins.bookstore.serviceimpl;

import com.reins.bookstore.dao.OrderDao;
import com.reins.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public List<Map> getManagerOrders(){
        return orderDao.getManagerOrders();
    }

    @Override
    public List<Map> getBuyManagerB(Date start, Date end){
        return orderDao.getBuyManagerB(start,end);
    }
    @Override
    public List<Map> getBuyManagerU(Date start, Date end){
        return orderDao.getBuyManagerU(start,end);
    }
}
