package com.reins.bookstore.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cart_item_id")
    private int cartItemId;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name="cart_id",nullable = false)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name="book_id",nullable = false)
    private Book abook;

    @Column(name = "count")
    private Integer count;

    public CartItem(){}

    public CartItem(Cart cart,Book abook,Integer count){
        this.cart=cart;
        this.abook=abook;
        this.count=count;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public Book getAbook() {
        return abook;
    }

    public void setAbook(Book abook) {
        this.abook = abook;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
