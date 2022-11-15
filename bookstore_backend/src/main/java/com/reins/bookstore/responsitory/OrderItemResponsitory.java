package com.reins.bookstore.responsitory;

import com.reins.bookstore.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemResponsitory extends JpaRepository<OrderItem,Integer> {
}
