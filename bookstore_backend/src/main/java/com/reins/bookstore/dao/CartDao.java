package com.reins.bookstore.dao;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.entity.Cart;
import com.reins.bookstore.entity.CartItem;

import java.util.List;
import java.util.Map;

public interface CartDao {

    boolean add(Integer uid,Integer bid,Integer bnum);

    List<Map> getCart(Integer uid);
    boolean checkoutCart(String address,Integer userid);
    Cart getcart(Integer uid);
}
