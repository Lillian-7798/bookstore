package com.reins.bookstore.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_item", schema = "bookStore(homework)", catalog = "")
public class OrderItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "itemId")
    private int itemId;

    @ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",nullable = false)
    private Orders order;

    @ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name="book_id",nullable = false)
    private Book abook;

    @Basic
    @Column(name = "count")
    private int count;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAbook(Book abook) {
        this.abook = abook;
    }

    public Book getAbook() {
        return abook;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public int getCount() {
        return count;
    }
}
