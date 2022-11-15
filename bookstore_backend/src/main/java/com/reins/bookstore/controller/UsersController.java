package com.reins.bookstore.controller;

import com.reins.bookstore.entity.Users;
import com.reins.bookstore.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@CrossOrigin(value = "http://localhost:8081",allowCredentials = "true")
@RestController
@Scope("session")
public class UsersController {

//    @Autowired
//    private UsersService usersService;
    @Autowired
    WebApplicationContext applicationContext;


    @RequestMapping("/checkUsers")
    public Map checkUser(@RequestParam("name") String username, @RequestParam("password") String password){
        UsersService usersService = applicationContext.getBean(UsersService.class);
        System.out.println("checkUsers!");
        return usersService.checkUser(username, password);
    }

    @RequestMapping("/time")
    public Long time(){
        UsersService usersService = applicationContext.getBean(UsersService.class);
        System.out.println("time!");
        System.out.println(this);
        System.out.println(usersService);
        return usersService.Logout();
    }


    @RequestMapping("/Register")
    public  boolean Register(@RequestParam("name") String username, @RequestParam("pass") String password){
        UsersService usersService = applicationContext.getBean(UsersService.class);
        System.out.println("Register!");
        return usersService.Register(username,password);
    }

    @RequestMapping("/getType")
    public Integer getType(@RequestParam("userid") int userid){
        UsersService usersService = applicationContext.getBean(UsersService.class);
        System.out.println("getType!");
        return usersService.getType(userid);
    }

    @RequestMapping("/getUserState")
    public Integer getUserState(@RequestParam("userid") int userid){
        UsersService usersService = applicationContext.getBean(UsersService.class);
        System.out.println("getUserState!");
        return usersService.getUserState(userid);
    }


    @RequestMapping("/getUsers")
    public List<Map> getUsers(){
        UsersService usersService = applicationContext.getBean(UsersService.class);
        System.out.println("getUsers!");
        return usersService.getUsers();
    }

    @RequestMapping("/changeState")
    public boolean changeState(@RequestParam("userid") int uid){
        UsersService usersService = applicationContext.getBean(UsersService.class);
        System.out.println("changeState!");
        return usersService.changeState(uid);
    }

    @RequestMapping("/checkDup")
    public boolean checkDup(@RequestParam("username") String username){
        UsersService usersService = applicationContext.getBean(UsersService.class);
        System.out.println("checkDup!");
        return usersService.checkDup(username);
    }

    @RequestMapping("/getOrders")
    public List<Map> getOrders(@RequestParam("userid") int uid){
        UsersService usersService = applicationContext.getBean(UsersService.class);
        System.out.println("getOrders!");
        return usersService.getOrders(uid);
    }

    @RequestMapping("/getBuyID")
    public List<Map> getBuyID(@RequestParam("userid") Integer uid, @RequestParam("start")String start,@RequestParam("end") String end){
        UsersService usersService = applicationContext.getBean(UsersService.class);
        System.out.println("getBuyID");
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date s = f.parse(start);
            Date e = f.parse(end);
            return usersService.getBuyID(uid,s,e);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }
}
