package com.reins.bookstore.controller;

import com.reins.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@CrossOrigin(value = "http://localhost:8081",allowCredentials = "true")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    @RequestMapping("/getManagerOrders")
    public List<Map> getManagerOrders(){return orderService.getManagerOrders();}

    @RequestMapping("/getBuyManagerB")
    public List<Map> getBuyManagerB(@RequestParam("start")String start, @RequestParam("end")String end){
        System.out.println("getBuyManagerB");
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date s = f.parse(start);
            Date e = f.parse(end);
            return orderService.getBuyManagerB(s,e);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }
    @RequestMapping("/getBuyManagerU")
    public List<Map> getBuyManagerU(@RequestParam("start")String start, @RequestParam("end")String end){
        System.out.println("getBuyManagerU");
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date s = f.parse(start);
            Date e = f.parse(end);
            return orderService.getBuyManagerU(s,e);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }


}
