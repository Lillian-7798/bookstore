package com.reins.bookstore.entity;

import java.math.BigDecimal;

public class RequestUser {
    private Users users;
    private BigDecimal price;

    public Users getUsers() {
        return users;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
