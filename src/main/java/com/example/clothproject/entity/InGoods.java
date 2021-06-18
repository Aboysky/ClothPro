package com.example.clothproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname InGoods
 * @Description TODO
 * @Date 2021/6/16 22:49
 * @Created by Huan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InGoods {
    private String adminId;
    private String goodsId;
    private String adminName;
    private String goodsName;
    private String size;
    private Integer amount;
    private String date;
    private String factory;
}

