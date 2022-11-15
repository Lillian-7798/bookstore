package com.reins.bookstore.serviceimpl;

import com.reins.bookstore.dao.BookDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public Book getBookDetails(Integer id){
        return bookDao.getBookDetails(id);
    }

    @Override
    public List<Book> getBooks(){return bookDao.getBooks();}

    @Override
    public boolean deleteBook(Integer bid){return bookDao.deleteBook(bid);}

    @Override
    public boolean EditBook(Integer bid,String bname,String bauthor,Integer inven,Integer isbn,String image)
    {
        return bookDao.EditBook(bid,bname,bauthor,inven,isbn,image);
    }

    @Override
    public void addBook(String bookName, String author, Integer isbn, String description, String type, Integer inven, BigDecimal price,String image){
        bookDao.addBook(bookName,author,isbn,description,type,inven,price,image);
    }

    @Override
    public List<String> SearchBook(String keyword){
        return bookDao.SearchBook(keyword);
    }
}
