package com.example.clothproject.controller;

import com.example.clothproject.entity.InGoods;
import com.example.clothproject.dao.InGoodsMapper;
import com.example.clothproject.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/c/ingoods")
public class InGoodsController {

    @Autowired
    InGoodsMapper inGoodsMapper;

    @RequestMapping("/list")
    public String listGoods(){
        List<InGoods> goods = inGoodsMapper.listInGoods();
        return ResUtil.getSucJsonData(goods);
    }

    @PostMapping("/search")
    public String searchGoods(String name){
        List<InGoods> goods = inGoodsMapper.searchInGoods(name);
        return ResUtil.getSucJsonData(goods);
    }

}