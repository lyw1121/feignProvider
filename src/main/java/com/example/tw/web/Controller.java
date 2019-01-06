package com.example.tw.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.djcps.redis.client.RedisClient;
import com.example.tw.Invoke;
import com.example.tw.Service.UserService;
import com.example.tw.dao.UserMapper;
import com.example.tw.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class Controller {
    @Autowired
    UserMapper userMapper;
    @Autowired
    Invoke invoke;
    @Autowired
    private RedisClient redisClient;
    @Autowired
    UserService userService;

    @RequestMapping(value = "insertUser" ,method=RequestMethod.POST)
    public String insertUser(@RequestParam("id") String id,
                             @RequestParam("name") String name,
                             @RequestParam("dept") String dept,
                             @RequestParam("phone") String phone,
                             @RequestParam("uname") String uname,
                             @RequestParam("password") String password){
        User user = new User();
        user.setPassword(password);
        user.setName(name);
        user.setUname(uname);
        user.setId(id);
        user.setDept(dept);
        user.setPhone(phone);
        int i = userService.insertUser(user);
        return i>0 ? "success":"false";
   }



    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam("id") String id){
        int i = userService.deleteById(id);
        redisClient.del("wanglistUser");
        return i>0 ? "删除成功":"false";
    }
    @RequestMapping("updateUser")
    public void updateUser(@RequestParam("id") String id,@RequestParam("uname") String uname,@RequestParam("password") String password){
        User user = new User();
        user.setId(id);
        user.setUname(uname);
        user.setPassword(password);
        userService.update(user);
    }
    @RequestMapping("listUser")
    public String listUser(){
        String listUser = redisClient.get("wanglistUser");
        List<User> arr = JSONArray.parseArray(listUser,User.class);
        if (arr==null){
            List<User> users= userService.listUser();
            String s = JSON.toJSONString(users);
            redisClient.set("wanglistUser",s);
            redisClient.expire("wanglistUser",5000);
           return users.toString();
        }else {
            return listUser;
        }
//        List<User> listUser = userService.listUser();
//        return listUser.toString();

    }
    @RequestMapping("move")
    public String move(){
       return invoke.listUser();
    }
}

