package com.reins.bookstore.responsitory;

import com.reins.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookResponsitory extends JpaRepository<Book,Integer> {

    @Query("from Book where bookId =:id")
    Book getBookDetails(Integer id);
    @Query("select b from Book b")
    List<Book> getBooks();
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value ="delete from book where book_id =?1")
    void deleteBook(Integer bid);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value ="update book set book_name=?2,author=?3,price=?4,inventory=?5 where book_id=?1")
    void EditBook(Integer bid,String bname,String bauthor,Integer bprice,Integer inven);

}
