package com.reins.bookstore.serviceimpl;

import com.reins.bookstore.dao.UsersDao;
import com.reins.bookstore.entity.Users;
import com.reins.bookstore.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Scope("session")
public class UsersServiceImpl implements UsersService{
    long start = 0;
    long end = 0;

    @Autowired
    UsersDao usersDao;

    @Override
    public Map checkUser(String username, String password){
        return usersDao.checkUser(username, password);
    }

    @Override
    public long Logout(){
        if(start==0){
            start = System.currentTimeMillis();
            return 0;
        }
        else{
            end = System.currentTimeMillis();
            System.out.println(start);
            System.out.println(end);
            long time = (end-start)/1000;
            start = 0;
            end = 0;
            return time;
        }
    }
    @Override
    public boolean Register(String username,String password) { return usersDao.Register(username,password);}

    @Override
    public Integer getType(int userid){
        return usersDao.getType(userid);
    }
    @Override
    public Integer getUserState(int userid){
        return usersDao.getUserState(userid);
    }

    @Override
    public List<Map> getUsers(){
        return usersDao.getUsers();
    }

    @Override
    public  boolean changeState(int uid){return usersDao.changeState(uid);}

    @Override
    public boolean checkDup(String username){return usersDao.checkDup(username);}

    @Override
    public List<Map> getOrders(Integer uid){return usersDao.getOrders(uid);}

    @Override
    public List<Map> getBuyID(Integer uid, Date start, Date end){
        return usersDao.getBuyID(uid,start,end);
    }
}
