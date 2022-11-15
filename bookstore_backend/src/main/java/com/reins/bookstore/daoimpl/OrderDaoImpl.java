package com.reins.bookstore.daoimpl;

import com.reins.bookstore.dao.OrderDao;
import com.reins.bookstore.entity.*;
import com.reins.bookstore.responsitory.OrderItemResponsitory;
import com.reins.bookstore.responsitory.OrdersResponsitory;
import com.reins.bookstore.responsitory.UsersResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    OrdersResponsitory ordersResponsitory;

    @Autowired
    UsersResponsitory usersResponsitory;

//    @Autowired
//    OrderItemResponsitory orderItemResponsitory;

    @Override
    public List<Map> getManagerOrders(){
        List<Orders> o = ordersResponsitory.findAll();
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
    public List<Map> getBuyManagerB(Date start, Date end){
        List<RequestBook> books = new ArrayList<>();
        for(Orders orders:ordersResponsitory.findAll()){
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
            tmp.put("price",b.getBook().getPrice());
            re.add(tmp);
        }
        return re;
    }

    @Override
    public List<Map> getBuyManagerU(Date start, Date end){
        List<RequestUser> users = new ArrayList<>();
        for(Orders orders:ordersResponsitory.findAll()){
            Date time = new Date(orders.getOrderDate().getTime());
            //判断订单时间
            if(time.after(start)&&time.before(end)){
                //计算订单总金额
                BigDecimal total = new BigDecimal(0);
                for(OrderItem item:orders.getOrderItems()){
                    total=total.add(item.getAbook().getPrice().multiply(BigDecimal.valueOf(item.getCount())));
                }
                boolean aflag =false;
                //判断user是否在list里面
                for(RequestUser tmp:users){
                    //存在的时候
                    if(tmp.getUsers().equals(orders.getUser())){
                        tmp.setPrice(tmp.getPrice().add(total));
                        aflag=true;
                        break;
                    }
                }
                //不存在的时候
                if(!aflag){
                    RequestUser requestUser = new RequestUser();
                    requestUser.setUsers(orders.getUser());
                    requestUser.setPrice(total);
                    users.add(requestUser);
                }
            }
        }
        //构造返回的list
        List<Map> re = new ArrayList<>();
        for(RequestUser u:users){
            Map<String,Object> tmp = new HashMap<>();
            tmp.put("id",u.getUsers().getUserId());
            tmp.put("name",u.getUsers().getUserName());
            tmp.put("total",u.getPrice());
            re.add(tmp);
        }
        return re;
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Orders setOrder(String address,Integer userid){
        List<Users> tmp = usersResponsitory.getUsersByID(userid);
        Orders order = new Orders();
        Timestamp d = new Timestamp(System.currentTimeMillis());
        order.setAddress(address);
        order.setUser(tmp.get(0));
        order.setOrderDate(d);
        ordersResponsitory.save(order);
//        int result = 10/0;
        return order;
    }
}
