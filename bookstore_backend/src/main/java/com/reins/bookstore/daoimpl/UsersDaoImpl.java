package com.reins.bookstore.daoimpl;

import com.reins.bookstore.dao.UsersDao;
import com.reins.bookstore.entity.*;
import com.reins.bookstore.responsitory.UsersResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class UsersDaoImpl implements UsersDao{

    @Autowired
    UsersResponsitory usersResponsity;

    @Override
    public Map checkUser(String username, String password){
        return usersResponsity.checkUser(username,password);
    }

    @Override
    public boolean Register(String username,String password) {
        Users a = new Users();
        a.setUserName(username);
        a.setPassword(password);
        a.setState(1);
        a.setType(1);
        usersResponsity.save(a);
        return true;
    }

    @Override
    public Integer getType(int userid){
        return usersResponsity.getType(userid);
    }
    @Override
    public Integer getUserState(int userid){
        return usersResponsity.getUserState(userid);
    }

    @Override
    public List<Map> getUsers(){
        List<Map> re = new ArrayList<>();
        for(Users users:usersResponsity.getUsers()){
            Map<String,Object> map= new HashMap<>();
            map.put("userId",users.getUserId());
            map.put("userName",users.getUserName());
            map.put("password",users.getPassword());
            map.put("type",users.getType());
            map.put("state",users.getState());
            re.add(map);
        }
        return re;
    }

    @Override
    public boolean changeState(int uid){
        Integer old=usersResponsity.getUserState(uid);
        Integer ne;
        if(old==0) ne=1;
        else ne=0;
        usersResponsity.setUserState(uid,ne);
        return true;
    }

    @Override
    public boolean checkDup(String username){
        if(usersResponsity.getUserByName(username).isEmpty()) return false;
        else return true;
    }

    @Override
    public List<Map> getOrders(Integer uid){
        Users user = usersResponsity.getUsersByID(uid).get(0);
        List<Orders> o = user.getOrders();
        List<Map> orders = new ArrayList<>();
        for(Orders order:o){
            BigDecimal total = new BigDecimal(0);
            Map<String,Object> map = new HashMap<>();
            map.put("id",order.getOrderId());
            map.put("time",order.getOrderDate());
            map.put("address",order.getAddress());
            List<Map> bookList = new ArrayList<>();
            for(OrderItem item:order.getOrderItems()){
                Map<String,Object> book = new HashMap<>();
                book.put("bookID",item.getAbook().getBookId());
                book.put("bookName",item.getAbook().getBookName());
                book.put("author",item.getAbook().getAuthor());
                book.put("img",item.getAbook().getImage());
                book.put("price",item.getAbook().getPrice());
                book.put("count",item.getCount());
                total=total.add(item.getAbook().getPrice().multiply(BigDecimal.valueOf(item.getCount())));
                bookList.add(book);
            }
            map.put("total",total);
            map.put("bookList",bookList);
            orders.add(map);
        }
        return orders;
    }

    @Override
    public List<Map> getBuyID(Integer uid, Date start,Date end){
        //获取书本list
        List<RequestBook> books = new ArrayList<>();
        for(Orders orders:usersResponsity.getUsersByID(uid).get(0).getOrders()){
            Date time = new Date(orders.getOrderDate().getTime());
            //判断订单时间
            if(time.after(start)&&time.before(end)){
                for(OrderItem orderItem:orders.getOrderItems()){
                    boolean aflag =false;
                    //这本书已经被选取了
                    for(RequestBook tmp :books){
                        if(tmp.getBook()==orderItem.getAbook()) {
                            tmp.setCount(tmp.getCount()+orderItem.getCount());
                            aflag =true;
                            break;
                        }
                    }
                    //这本书没有被选取
                    if(!aflag){
                        RequestBook requestBook = new RequestBook();
                        requestBook.setBook(orderItem.getAbook());
                        requestBook.setCount(orderItem.getCount());
                        books.add(requestBook);
                    }
                }
            }
        }
        //构造返回的list
        List<Map> re = new ArrayList<>();
        for(RequestBook b:books){
            Map<String,Object> tmp = new HashMap<>();
            tmp.put("name",b.getBook().getBookName());
            tmp.put("count",b.getCount());
            tmp.put("price",b.getBook().getPrice().multiply(BigDecimal.valueOf(b.getCount())));
            re.add(tmp);
        }
        return re;
    }
}
