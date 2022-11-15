package com.reins.bookstore.entity;

import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Field("book_id")
    @Column(name = "bookId")
    private int bookId;
    @Basic
    @Field("book_name")
    @Column(name = "bookName")
    private String bookName;
    @Basic
    @Field("price")
    @Column(name = "price")
    private BigDecimal price;
    @Basic
    @Field("bookType")
    @Column(name = "bookType")
    private String bookType;
    @Basic
    @Field("author")
    @Column(name = "author")
    private String author;
    @Basic
    @Field("bookDescription")
    @Column(name = "bookDescription")
    private String bookDescription;
    @Basic
    @Field("inventory")
    @Column(name = "inventory")
    private int inventory;
    @Basic
    @Field("image")
    @Column(name = "image")
    private String image;

    @Basic
    @Field("isbn")
    @Column(name = "isbn")
    private Integer isbn;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }
}
