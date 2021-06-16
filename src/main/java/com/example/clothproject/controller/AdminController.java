package com.example.clothproject.controller;

import com.example.clothproject.entity.Admin;
import com.example.clothproject.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname AdminController
 * @Description TODO
 * @Date 2021/6/16 23:18
 * @Created by Huan
 */
@Controller
@RequestMapping("/c")
public class AdminController {

    @Autowired
    AdminMapper adminMapper;

    @PostMapping("/login")
    public String login(String username,String password) {
        Admin user = adminMapper.login(username);
        if (user != null) {

            user.getPassword()
        }
    }
}
