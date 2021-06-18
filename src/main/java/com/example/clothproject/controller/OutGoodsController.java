package com.example.clothproject.controller;

import com.example.clothproject.entity.OutGoods;
import com.example.clothproject.entity.OutGoods;
import com.example.clothproject.dao.OutGoodsMapper;
import com.example.clothproject.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/c/outgoods")
@ResponseBody
public class OutGoodsController {
    @Autowired
    OutGoodsMapper outGoodsMapper;

    @RequestMapping("/list")
    public String listOutGoods(){
        List<OutGoods> goods = outGoodsMapper.listOutGoods();
        return ResUtil.getJsonStrJackon(200,"success",goods);
    }

    @PostMapping("/search")
    public String searchGoods(@RequestBody OutGoods outGoods){
        List<OutGoods> goods = outGoodsMapper.searchOutGoods(outGoods);
        return ResUtil.getJsonStrJackon(200,"success",goods);
    }

    @PutMapping("/c/outGoods")
    public String updateGoods(@RequestBody OutGoods outGoods) {
        OutGoods res = outGoodsMapper.updateOutGoods(outGoods);
        return ResUtil.getJsonStrJackon(200,"success",res);
    }

    @DeleteMapping("/c/outGoods")
    public String deleteGoods(@RequestBody OutGoods outGoods) {
        int res = outGoodsMapper.deleteOutGoods(outGoods);
        return ResUtil.getJsonStrJackon(200,"success",res);
    }
}
