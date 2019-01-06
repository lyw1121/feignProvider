package com.example.tw.Service;

import com.example.tw.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface UserService {
    //添加用户
    int insertUser(User user);
    //删除用户
    int deleteById(String id);
    //修改用户
    int update(User user);
    //查询用户
     List<User> listUser();
}
