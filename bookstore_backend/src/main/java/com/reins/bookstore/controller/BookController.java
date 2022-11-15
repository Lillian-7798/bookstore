package com.reins.bookstore.controller;

import com.reins.bookstore.entity.Book;
import com.reins.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;


@CrossOrigin(value = "http://localhost:8081",allowCredentials = "true")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/getBooks")
    public List<Book> getBooks(){
        System.out.println("getBooks!");
        return bookService.getBooks();
    }

    @RequestMapping("/getBookDetails")
    public Book getBookDetails(@RequestParam("id") Integer id){
        System.out.println("getBookDetails!");
        return bookService.getBookDetails(id);
    }

    @RequestMapping("/deleteBook")
    public boolean deleteBook(@RequestParam("bookid") Integer bid){
        System.out.println("deleteBook!");
        return bookService.deleteBook(bid);
    }

    @RequestMapping("/EditBook")
    public boolean EditBook(@RequestParam("bookid") Integer bid,
                            @RequestParam("name") String bname,
                            @RequestParam("author") String bauthor,
                            @RequestParam("inventory") Integer inven,
                            @RequestParam("isbn") Integer isbn,
                            @RequestParam("image") String image)
    {
        System.out.println("EditBook!");
        return bookService.EditBook(bid,bname,bauthor,inven,isbn,image);
    }

    @RequestMapping("/addBook")
    public boolean addBook(@RequestParam("bookName") String bookName,
                           @RequestParam("author") String author,
                           @RequestParam("isbn") Integer isbn,
                           @RequestParam("description") String description,
                           @RequestParam("type") String type,
                           @RequestParam("inventory") Integer inven,
                           @RequestParam("price") String p,
                           @RequestParam("image") String image){
        System.out.println("add new book!");
        BigDecimal price = new BigDecimal(p);
        bookService.addBook(bookName,author,isbn,description,type,inven,price,image);
        return true;
    }
    @RequestMapping("/SearchBookbyDescrip")
    public List<String> SearchBook(@RequestParam("keyword") String keyword){
        return bookService.SearchBook(keyword);
    }
}
