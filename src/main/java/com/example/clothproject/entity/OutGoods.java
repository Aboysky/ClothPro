package com.example.clothproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname OutGoods
 * @Description TODO
 * @Date 2021/6/16 22:50
 * @Created by Huan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutGoods {
    private String adminId;
    private String goodsId;
    private String adminName;
    private String goodsName;
    private String size;
    private Integer amount;
    private String date;
    private String factory;
}
