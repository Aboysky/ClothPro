package com.example.clothproject.controller;

import com.example.clothproject.entity.User;
import com.example.clothproject.entity.User;
import com.example.clothproject.dao.UserMapper;
import com.example.clothproject.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2021/6/16 22:59
 * @Created by Huan
 */
@Controller
@RequestMapping("/c/user")
@ResponseBody
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/list")
    public String listUsers(){
        List<User> users = userMapper.listUsers();
        return ResUtil.getJsonStrJackon(200,"success",users);
    }

    @PostMapping("/search")
    public String searchUsers(@RequestBody User user){
        List<User> users = userMapper.searchUsers(user);
        return ResUtil.getJsonStrJackon(200,"success",users);
    }

    @PutMapping("/c/user")
    public String updateGoods(@RequestBody User user) {
        User res = userMapper.updateUser(user);
        return ResUtil.getJsonStrJackon(200,"success",res);
    }

    @DeleteMapping("/c/user")
    public String deleteGoods(@RequestBody User user) {
        int res = userMapper.deleteUser(user);
        return ResUtil.getJsonStrJackon(200,"success",res);
    }



}
