package com.reins.bookstore.serviceimpl;

import com.reins.bookstore.dao.CartDao;
import com.reins.bookstore.dao.OrderDao;
import com.reins.bookstore.dao.OrderItemDao;
import com.reins.bookstore.entity.Cart;
import com.reins.bookstore.entity.CartItem;
import com.reins.bookstore.entity.OrderItem;
import com.reins.bookstore.entity.Orders;
import com.reins.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    @Autowired
    OrderItemDao orderItemDao;

    @Autowired
    OrderDao orderDao;

    @Override
    public boolean add(Integer uid,Integer bid,Integer bnum){
        return cartDao.add(uid,bid,bnum);
    }

    @Override
    public List<Map> getCart(Integer uid){
        return cartDao.getCart(uid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean checkoutCart(String address,Integer userid) {
        Cart cart = cartDao.getcart(userid);
        if(cart==null) return false;
        else{
            if(cart.getCartItems().isEmpty()) return false;
            else{
                //插入order记录
                Orders orders = orderDao.setOrder(address,userid);
                //先插入orderitems记录
                orderItemDao.setOrderItems(cart,orders);
                cart.setCartItems(new ArrayList<>());
//                throw new RuntimeException("checkout throw exception");
                return true;
            }
        }
//        return cartDao.checkoutCart(address,userid);
    }
}
