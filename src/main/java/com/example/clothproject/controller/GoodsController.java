package com.example.clothproject.controller;

import com.example.clothproject.entity.Goods;
import com.example.clothproject.dao.GoodsMapper;
import com.example.clothproject.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String searchGoods(@RequestBody Goods goods){
        List<Goods> res = goodsMapper.searchGoods(goods);
        return ResUtil.getSucJsonData(res);
    }

}
