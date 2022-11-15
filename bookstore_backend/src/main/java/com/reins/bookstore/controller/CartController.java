package com.reins.bookstore.controller;

import com.reins.bookstore.entity.CartItem;
import com.reins.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@CrossOrigin(value = "http://localhost:8081",allowCredentials = "true")
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/addToCart")
    public boolean addToCart(@RequestParam("userId") Integer uid,
                             @RequestParam("bookId") Integer bid,
                             @RequestParam("bookNum") Integer bnum){
        System.out.println("addToCart!");
        return cartService.add(uid,bid,bnum);
    }

    @RequestMapping("/getCart")
    public List<Map> getCart(@RequestParam("userId") Integer uid){
        System.out.println("getCart!");
        return cartService.getCart(uid);
    }

    @RequestMapping("/checkoutCart")
    public boolean checkoutCart(@RequestParam("address") String address,@RequestParam("userId") Integer userid){
        System.out.println("checkout!");
        String data = address+','+userid;
        System.out.println(data);
        kafkaTemplate.send("topic1","key",data);
//        cartService.checkoutCart(address,userid);
        return true;
    }
}
