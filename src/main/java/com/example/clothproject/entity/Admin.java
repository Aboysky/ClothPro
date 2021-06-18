package com.example.clothproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Admin
 * @Description TODO
 * @Date 2021/6/16 22:48
 * @Created by Huan
// */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private String username;
    private String password;
    private Integer auth;
    private String gender;
    private Integer age;
    private String tel;
}

