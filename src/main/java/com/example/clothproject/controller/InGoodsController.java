package com.example.clothproject.controller;

import com.example.clothproject.entity.InGoods;
import com.example.clothproject.entity.InGoods;
import com.example.clothproject.dao.InGoodsMapper;
import com.example.clothproject.util.ResUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/c/ininGoods")
@ResponseBody
public class InGoodsController {

    @Autowired
    InGoodsMapper inGoodsMapper;

    @RequestMapping("/list")
    public String listGoods(){
        List<InGoods> res = inGoodsMapper.listInGoods();
        return ResUtil.getJsonStrJackon(200,"success",res);
    }

    @PostMapping("/search")
    public String searchGoods(@RequestBody InGoods inGoods){
        List<InGoods> res = inGoodsMapper.searchInGoods(inGoods);
        return ResUtil.getJsonStrJackon(200,"success",res);
    }

    @PutMapping("/c/inGoods")
    public String updateGoods(@RequestBody InGoods inGoods) {
        InGoods res = inGoodsMapper.updateInGoods(inGoods);
        return ResUtil.getJsonStrJackon(200,"success",res);
    }

    @DeleteMapping("/c/inGoods")
    public String deleteGoods(@RequestBody InGoods inGoods) {
        int res = inGoodsMapper.deleteInGoods(inGoods);
        return ResUtil.getJsonStrJackon(200,"success",res);
    }
}
