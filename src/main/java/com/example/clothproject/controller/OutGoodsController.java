package com.example.clothproject.controller;

import com.example.clothproject.entity.OutGoods;
import com.example.clothproject.dao.OutGoodsMapper;
import com.example.clothproject.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/c/outgoods")
public class OutGoodsController {
    @Autowired
    OutGoodsMapper outGoodsMapper;

    @RequestMapping("/list")
    public String listOutGoods(){
        List<OutGoods> goods = outGoodsMapper.listOutGoods();
        return ResUtil.getSucJsonData(goods);
    }

    @PostMapping("/search")
    public String searchGoods(String name){
        List<OutGoods> goods = outGoodsMapper.searchOutGoods(name);
        return ResUtil.getSucJsonData(goods);
    }
}
