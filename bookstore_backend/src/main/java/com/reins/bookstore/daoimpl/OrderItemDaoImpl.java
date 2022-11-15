package com.reins.bookstore.daoimpl;

import com.reins.bookstore.dao.OrderItemDao;
import com.reins.bookstore.entity.Cart;
import com.reins.bookstore.entity.CartItem;
import com.reins.bookstore.entity.OrderItem;
import com.reins.bookstore.entity.Orders;
import com.reins.bookstore.responsitory.CartItemResponsitory;
import com.reins.bookstore.responsitory.OrderItemResponsitory;
import com.reins.bookstore.responsitory.OrdersResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {

    @Autowired
    OrderItemResponsitory orderItemResponsitory;

    @Autowired
    CartItemResponsitory cartItemResponsitory;

    @Autowired
    OrdersResponsitory ordersResponsitory;
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<OrderItem> setOrderItems(Cart cart,Orders orders){
        List<OrderItem> orderItems = new ArrayList<>();
                for(CartItem item:cart.getCartItems()){
                    //新建订单和订单项
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrder(orders);
                    orderItem.setAbook(item.getAbook());
                    orderItem.setCount(item.getCount());
                    orderItems.add(orderItem);
                    orderItemResponsitory.save(orderItem);
                    //删除购物车项
                    cartItemResponsitory.delete(item);
                    //减库存
                    item.getAbook().setInventory(item.getAbook().getInventory()-item.getCount());
                }
                return orderItems;
//        int result = 10/0;
    }
}
