package com.example.clothproject.controller;

import com.example.clothproject.entity.Goods;
import com.example.clothproject.dao.GoodsMapper;
import com.example.clothproject.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Classname GoodsController
 * @Description TODO
 * @Date 2021/6/16 23:14
 * @Created by Huan
 */
@Controller
@RequestMapping("/c/admin/list")
public class GoodsController {
    @Autowired
    GoodsMapper goodsMapper;


    @RequestMapping("/list")
    public String listGoods(){
        List<Goods> goods = goodsMapper.listGoods();
        return ResUtil.getSucJsonData(goods);
    }

    @PostMapping("/search")
    public String searchGoods(String name){
        List<Goods> goods = goodsMapper.searchGoods(name);
        return ResUtil.getSucJsonData(goods);
    }

}
