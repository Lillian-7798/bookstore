package com.reins.bookstore.service;

import com.reins.bookstore.entity.CartItem;

import java.util.List;
import java.util.Map;

public interface CartService {
    boolean add(Integer uid,Integer bid,Integer bnum);

    List<Map> getCart(Integer uid);

    boolean checkoutCart(String address,Integer userid);
}
