package com.reins.bookstore.responsitory;

import com.reins.bookstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartResponsitory extends JpaRepository<Cart,Integer> {


}
