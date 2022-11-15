package com.reins.bookstore.dao;

import com.reins.bookstore.entity.Cart;
import com.reins.bookstore.entity.CartItem;
import com.reins.bookstore.entity.OrderItem;
import com.reins.bookstore.entity.Orders;

import java.util.List;

public interface OrderItemDao {

    List<OrderItem> setOrderItems(Cart cart,Orders orders);
}
