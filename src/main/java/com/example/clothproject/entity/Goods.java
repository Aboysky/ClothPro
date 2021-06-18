package com.example.clothproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Goods
 * @Description TODO
 * @Date 2021/6/16 22:46
 * @Created by Huan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private String id;
    private String name;
    private String size;
    private Integer amount;
    private String data;
    private String factory;
}
