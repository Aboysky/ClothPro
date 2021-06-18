package com.example.clothproject.controller;

import com.example.clothproject.entity.Goods;
import com.example.clothproject.entity.Goods;
import com.example.clothproject.dao.GoodsMapper;
import com.example.clothproject.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname GoodsController
 * @Description TODO
 * @Date 2021/6/16 23:14
 * @Created by Huan
 */
@Controller
@RequestMapping("/c/goods")
@ResponseBody
public class GoodsController {
    @Autowired
    GoodsMapper goodsMapper;


    @RequestMapping("/list")
    public String listGoods(){
        List<Goods> goods = goodsMapper.listGoods();
        return ResUtil.getJsonStrJackon(200,"success",goods);
    }

    @PostMapping("/search")
    public String searchGoods(@RequestBody Goods goods){
        List<Goods> res = goodsMapper.searchGoods(goods);
        return ResUtil.getJsonStrJackon(200,"success",res);
    }

    @PutMapping("/c/goods")
    public String updateGoods(@RequestBody Goods goods) {
        Goods res = goodsMapper.updateGoods(goods);
        return ResUtil.getJsonStrJackon(200,"success",res);
    }

    @DeleteMapping("/c/goods")
    public String deleteGoods(@RequestBody Goods goods) {
        int res = goodsMapper.deleteGoods(goods);
        return ResUtil.getJsonStrJackon(200,"success",res);
    }

}
