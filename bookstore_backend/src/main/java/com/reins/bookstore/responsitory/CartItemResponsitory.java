package com.reins.bookstore.responsitory;

import com.reins.bookstore.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CartItemResponsitory extends JpaRepository<CartItem,Integer> {
    @Query(nativeQuery = true,value = "select book.book_id,author,book_name,price,count,image from book,cart_item where book.book_id=cart_item.book_id and cart_item.cart_id=?1")
    List<Map> getCart(Integer cid);
}
