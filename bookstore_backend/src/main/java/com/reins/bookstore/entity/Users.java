package com.reins.bookstore.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userId")
    private int userId;
    @Basic
    @Column(name = "userName")
    private String userName;
    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "type")
    private Integer type;

    @Basic
    @Column(name = "state")
    private Integer state;

    @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)//懒加载，全部关联操作
    @JoinColumn(name="cart_id",referencedColumnName = "cartId")//user表中的cart_id关联cart表中的cart_id
    private Cart cart;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "user")
    private List<Orders> orders = new ArrayList<>();

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType(){return type;}
    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState(){return state;}
    public void setState(Integer state) {
        this.state = state;
    }
}
