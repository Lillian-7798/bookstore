package com.reins.bookstore.responsitory;

import com.reins.bookstore.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface UsersResponsitory extends JpaRepository<Users,Integer>{

    @Query(nativeQuery = true,value = "select user_id,user_name,type,state from users where user_name=?1 and password=?2")
    Map checkUser(@Param("name") String username, @Param("password") String password);

    @Query(nativeQuery = true,value = "select type from users where user_id=?1")
    Integer getType(int userid);
    @Query(nativeQuery = true,value = "select state from users where user_id=?1")
     Integer getUserState(int userid);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update users set state=?2 where user_id=?1")
    void setUserState(int uid,Integer ne);
    @Query(value ="select u from Users u")
    List<Users> getUsers();

    @Query(value = "from Users where userName=:name")
    List<Users> getUserByName(@Param("name") String username);

    @Query(value = "from Users where userId=:ID")
    List<Users> getUsersByID(@Param("ID")Integer userid);
}
