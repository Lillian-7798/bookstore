package com.reins.bookstore.responsitory;

import com.reins.bookstore.entity.Orders;
import com.reins.bookstore.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersResponsitory extends JpaRepository<Orders,Integer> {

    @Query(value = "from Orders where orderId=:ID")
    List<Orders> getOrderssByID(@Param("ID")Integer orderId);
}
