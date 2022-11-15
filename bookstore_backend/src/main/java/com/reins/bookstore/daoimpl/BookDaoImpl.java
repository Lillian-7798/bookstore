package com.reins.bookstore.daoimpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.reins.bookstore.dao.BookDao;
import com.reins.bookstore.entity.Book;
import com.reins.bookstore.responsitory.BookResponsitory;
import com.reins.bookstore.utils.Redis.RedisUtil;
import com.alibaba.fastjson.JSONArray;
import com.reins.bookstore.utils.solrj.BookBinding;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.reins.bookstore.utils.solrj.BookBinding.getSolrClient;

@Repository
public class BookDaoImpl implements BookDao {
    static boolean flag = false;
    @Autowired
    BookResponsitory bookResponsity;
    @Autowired
    RedisUtil redisUtil;


    @Override
    public Book getBookDetails(Integer id){
        System.out.println("get book"+id);
        Book book = null;
        System.out.println("Search book "+id+" in redis.");
        Object b = redisUtil.get("book"+id);
        if(b==null) {
            System.out.println("not in redis.");
            System.out.println("Searching book: " + id + " in DB");
            book = bookResponsity.getBookDetails(id);
            redisUtil.set("book" + id, JSONArray.toJSON(book));
        }else{
            book = JSONArray.parseObject(b.toString(), Book.class);
            System.out.println("book: " + id + " is in Redis");
        }
        return book;
    }

    @Override
    public List<Book> getBooks() {
        return bookResponsity.getBooks();
    }

    @Override
    public boolean deleteBook(Integer bid){
        System.out.println("delete book"+bid);
        Book book = null;
        System.out.println("Search book "+bid+" in redis.");
        Object b = redisUtil.get("book"+bid);
        if(b==null) {
            System.out.println("not in redis.");
        }else{
            System.out.println("book: " + bid + " is in Redis");
            System.out.println("Delete book "+bid+" in redis.");
            redisUtil.del("book"+bid);
        }
        bookResponsity.deleteBook(bid);
        System.out.println("Delete book "+bid+" in DB.");
        return true;
    }

    @Override
    public boolean EditBook(Integer bid,String bname,String bauthor,Integer inven,Integer isbn,String image)
    {
        System.out.println("Update book"+bid);
        //get book by id
        Book book = null;
        System.out.println("Search book "+bid+" in redis.");
        Object b = redisUtil.get("book"+bid);
        if(b==null) {
            System.out.println("not in redis.");
            System.out.println("Searching book: " + bid + " in DB");
            book = bookResponsity.getBookDetails(bid);
        }else{
            book = JSONArray.parseObject(b.toString(), Book.class);
            System.out.println("book: " + bid + " is in Redis");
            redisUtil.del("book"+bid);
            System.out.println("Delete book "+bid+" in redis.");
        }

        book.setBookName(bname);
        book.setAuthor(bauthor);
        book.setInventory(inven);
        book.setIsbn(isbn);
        book.setImage(image);
        bookResponsity.save(book);
        System.out.println("update book"+bid+" in DB");
        return true;
    }

    @Override
    public void addBook(String bookName, String author, Integer isbn, String description, String type, Integer inven, BigDecimal price,String image){
        Book book=new Book();
        book.setBookName(bookName);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setBookDescription(description);
        book.setBookType(type);
        book.setInventory(inven);
        book.setPrice(price);
        book.setImage(image);
        bookResponsity.save(book);
        System.out.println("Add book"+book.getBookId()+" in DB");
        redisUtil.set("book" +book.getBookId(), JSONArray.toJSON(book));
        System.out.println("Add book"+book.getBookId()+" in redis");
    }

    @Override
    public List<String> SearchBook(String keyword){

        SolrClient client = getSolrClient();

        if(!flag) {
            List<Book> books = bookResponsity.getBooks();
            for (Book b : books) {
                System.out.println("input book:" + b.getBookId());
                try {
                    final UpdateResponse response = client.addBean("try", b);
                    client.commit("try");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (SolrServerException e) {
                    throw new RuntimeException(e);
                }
            }
            flag = true;
        }
        SolrQuery query = new SolrQuery();
        query.setQuery(keyword);
        query.set("df","bookDescription");
        QueryResponse responseOne;
        List<String> booklist = new ArrayList<>();
        try {
            responseOne = client.query("try",query);
            if (responseOne != null) {
//                productInfoList = response.getBeans(ProductInfo.class);
                SolrDocumentList results = responseOne.getResults();
                for (SolrDocument document: results
                ) {
                    Book book;
                    String jsonString = JSON.toJSONString(document);
                    booklist.add(jsonString);
//                    book = JSONObject.parseObject(jsonString,Book.class);
//                    booklist.add(book);
                }
            } else {
                System.out.println("solr查询为空");
            }
        } catch (SolrServerException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return booklist;
    }
}
