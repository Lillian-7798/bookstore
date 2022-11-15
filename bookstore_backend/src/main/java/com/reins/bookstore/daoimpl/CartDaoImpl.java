package com.reins.bookstore.daoimpl;

import com.reins.bookstore.dao.CartDao;
import com.reins.bookstore.entity.*;
import com.reins.bookstore.responsitory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import  java.util.List;
import java.util.Map;

@Repository
public class CartDaoImpl implements CartDao {
    @Autowired
    CartResponsitory cartResponsitory;

    @Autowired
    UsersResponsitory usersResponsitory;

    @Autowired
    CartItemResponsitory cartItemResponsitory;

    @Autowired
    BookResponsitory bookResponsitory;

    @Autowired
    OrderItemResponsitory orderItemResponsitory;

    @Autowired
    OrdersResponsitory ordersResponsitory;

    @Override
    public boolean add(Integer uid,Integer bid,Integer bnum){
        List<Users> tmp = usersResponsitory.getUsersByID(uid);
        if(tmp.isEmpty()) return false;
        else{
            //存在购物车的时候
            if(tmp.get(0).getCart()!=null) {
                Cart cart=tmp.get(0).getCart();
                List<CartItem> cartItems = cart.getCartItems();
                //如果购物车里已经有这本书，直接加数量
                for (CartItem item : cartItems) {
                    if (item.getAbook().getBookId() == bid) {
                        item.setCount(item.getCount() + bnum);
                        cartItemResponsitory.save(item);
                        return true;
                    }
                }
                //购物车里没有这本书，加item
                CartItem cartItem = new CartItem(cart, bookResponsitory.getBookDetails(bid), bnum);
                cartItemResponsitory.save(cartItem);
            }
            //不存在购物车时
            else{
                //新建一个购物车
                Users users= tmp.get(0);
                users.setCart(new Cart());
                usersResponsitory.save(users);
                Cart cart=users.getCart();
                CartItem cartItem = new CartItem(cart, bookResponsitory.getBookDetails(bid), bnum);
                cartItemResponsitory.save(cartItem);
            }
            return true;
        }
    }

    @Override
    public List<Map> getCart(Integer uid){
        List<Users> tmp = usersResponsitory.getUsersByID(uid);
        if(tmp.isEmpty()) return null;
        else{
            if(tmp.get(0).getCart()==null) return null;
            else return cartItemResponsitory.getCart(tmp.get(0).getCart().getCartId());
        }
//        return cartResponsitory.getCart(uid);
    }

    @Override
    public  Cart getcart(Integer uid){
        List<Users> tmp = usersResponsitory.getUsersByID(uid);
        if(tmp.isEmpty()) return null;
        else return tmp.get(0).getCart();
    }
    @Override
    public boolean checkoutCart(String address,Integer userid) {
        return true;
//        List<Users> tmp = usersResponsitory.getUsersByID(userid);
//        if (tmp.isEmpty()) return false;
//        else {
//            Users user = tmp.get(0);
//            Cart cart = user.getCart();
//            if(cart.getCartItems().isEmpty()) return false;
//            else{
//                Orders order = new Orders();
//                Timestamp d = new Timestamp(System.currentTimeMillis());
//                order.setAddress(address);
//                order.setUser(user);
//                order.setOrderDate(d);
//                List<OrderItem> orderItems = new ArrayList<>();
//                for(CartItem item:cart.getCartItems()){
//                    //新建订单和订单项
//                    OrderItem orderItem = new OrderItem();
//                    orderItem.setOrder(order);
//                    orderItem.setAbook(item.getAbook());
//                    orderItem.setCount(item.getCount());
//                    orderItems.add(orderItem);
//                    orderItemResponsitory.save(orderItem);
//                    //删除购物车项
//                    cartItemResponsitory.delete(item);
//                    //减库存
//                    item.getAbook().setInventory(item.getAbook().getInventory()-item.getCount());
//                }
//                cart.setCartItems(new ArrayList<>());
//                order.setOrderItems(orderItems);
//                ordersResponsitory.save(order);
//                return true;
//            }
//        }
    }
}
