package com.example.clothproject.controller;

import com.example.clothproject.entity.Admin;
import com.example.clothproject.dao.AdminMapper;
import com.example.clothproject.util.ResUtil;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

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
        Map<String,String> res =  new HashMap<>();
        if (user != null) {
            String dbPass = user.getPassword();
            if (Strings.isNotBlank(dbPass) && dbPass.equals(password)) {
                res.put("username",user.getUsername());
                res.put("auth","0");
            } else {
                res.put("username",user.getUsername());
                res.put("auth","1");
            }
        } else {
            res.put("auth","2");
        }
        return ResUtil.getSucJsonData(res);
    }

    @PostMapping("/register")
    public String register(String username,String password) {
        if (Strings.isBlank(username) || Strings.isBlank(password)) {
            return ResUtil.getErrDes("用户名或密码不能为空");
        }
        Admin admin = adminMapper.login(username);
        if (admin == null) {
            int num = adminMapper.register(username.trim(),password.trim());
            if (num >= 1) {
                return ResUtil.getSucDes("创建用户成功");
            } else {
                return ResUtil.getErrDes("服务器错误！");
            }
        } else {
            return ResUtil.getErrDes("用户已存在");
        }
    }

    @RequestMapping("/goods/list")
    public String listAdmins() {
        return ResUtil.getSucJsonData(adminMapper.listAdmins());
    }

    @PostMapping("/goods/search")
    public String listAdmins(String name) {
        Admin user = adminMapper.login(name);
        user.setPassword("");
        return ResUtil.getSucJsonData(user);
    }
}
