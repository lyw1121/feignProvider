package com.example.tw.dao;

import com.example.tw.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //增加用户
    int insert(User user);
    //删除用户
    int delete(String id);
    //修改用户
    int update(User user);
    //查询用户
    List<User> listUser();
    //登入
    User confirm(User user);
}
