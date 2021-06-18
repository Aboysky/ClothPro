package com.example.clothproject.controller;

import com.example.clothproject.entity.Admin;
import com.example.clothproject.dao.AdminMapper;
import com.example.clothproject.entity.User;
import com.example.clothproject.util.ResUtil;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname AdminController
 * @Description TODO
 * @Date 2021/6/16 23:18
 * @Created by Huan
 */
@Controller
@ResponseBody
public class AdminController {

    @Autowired
    AdminMapper adminMapper;

    @PostMapping("/c/login")
    public String login(@RequestBody Admin user) {
        Admin user1 = adminMapper.login(user.getUsername());
        Map<String,String> res =  new HashMap<>();
        if (user1 != null) {
            String dbPass = user1.getPassword();
            if (Strings.isNotBlank(dbPass) && dbPass.equals(user.getPassword())) {
                res.put("username",user1.getUsername());
                res.put("auth","0");
            } else {
                res.put("username",user1.getUsername());
                res.put("auth","1");
            }
        } else {
            res.put("auth","2");
        }
        return ResUtil.getJsonStrJackon(200,"success",res);
    }

    @PostMapping("/c/register")
    public String register(@RequestBody Admin user) {
        if (Strings.isBlank(user.getUsername()) || Strings.isBlank(user.getPassword())) {
            return ResUtil.getErrDes("用户名或密码不能为空");
        }
        Admin admin = adminMapper.login(user.getUsername());
        if (admin == null) {

            int num = adminMapper.register(user.getUsername().trim(),user.getPassword().trim(),1);
            if (num >= 1) {
                return ResUtil.getJsonStr(200,"success！",1);
            } else {
                return ResUtil.getJsonStr(500,"服务器错误！",new Integer(3));
            }
        } else {
            return ResUtil.getJsonStr(500,"用户已存在！",2);
        }
    }

    @RequestMapping("/c/admin/list")
    public String listAdmins() {
        return ResUtil.getJsonStrJackon(200,"success",adminMapper.listAdmins());
    }

    @PostMapping("/c/admin/search")
    public String listAdmins(@RequestBody Admin admin) {
        List<Admin> admins = adminMapper.searchAdmins(admin);
        return ResUtil.getJsonStrJackon(200,"success",admins);
    }

    @PutMapping("/c/admin")
    public String updateAdmin(@RequestBody Admin admin) {
        Admin res = adminMapper.updateAdmin(admin);
        return ResUtil.getJsonStrJackon(200,"success",res);
    }

    @DeleteMapping("/c/admin")
    public String deleteAdmin(@RequestBody Admin admin) {
        int res = adminMapper.deleteAdmin(admin);
        return ResUtil.getJsonStrJackon(200,"success",res);
    }
}
