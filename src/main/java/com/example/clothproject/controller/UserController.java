package com.example.clothproject.controller;

import com.example.clothproject.entity.User;
import com.example.clothproject.mapper.UserMapper;
import com.example.clothproject.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/6/16 22:59
 * @Created by Huan
 */
@Controller
@RequestMapping("/c")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/user/list")
    public String listUsers(){
        List<User> users = userMapper.listUsers();
        return ResUtil.getSucJsonData(users);
    }

    @PostMapping("/user/search")
    public String searchUsers(String name){
        List<User> users = userMapper.searchUsers(name);
        return ResUtil.getSucJsonData(users);
    }

    @PostMapping("/login")
    public String login(String username,String password) {

    }


}