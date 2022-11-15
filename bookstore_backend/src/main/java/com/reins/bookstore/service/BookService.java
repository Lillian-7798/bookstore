package com.reins.bookstore.service;

import com.reins.bookstore.entity.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {

    Book getBookDetails(Integer id);
    List<Book> getBooks();
    boolean deleteBook(Integer bid);
    boolean EditBook(Integer bid,String bname,String bauthor,Integer inven,Integer isbn,String image);
    void addBook(String bookName, String author, Integer isbn, String description, String type, Integer inven, BigDecimal price,String image);
    List<String> SearchBook(String keyword);
}
