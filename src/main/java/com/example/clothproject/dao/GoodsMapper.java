package com.example.clothproject.dao;

import com.example.clothproject.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname GoodsMapper
 * @Description TODO
 * @Date 2021/6/16 23:16
 * @Created by Huan
 */
@Mapper
public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> listGoods();

    @Select({"<script>",
            "SELECT * FROM goods",
            "WHERE 1=1 ",
            "<when test='goods.id!=null'>",
            "AND id = #{goods.id}",
            "</when>",
            "<when test='goods.name!=null'>",
            "AND name = #{goods.name}",
            "</when>",
            "<when test='goods.size!=null'>",
            "AND size = #{goods.size}",
            "</when>",
            "<when test='goods.amount!=null'>",
            "AND amount = #{goods.amount}",
            "</when>",
            "<when test='goods.date!=null'>",
            "AND date = #{goods.date}",
            "</when>",
            "<when test='goods.factory!=null'>",
            "AND factory = #{goods.factory}",
            "</when>",
            "</script>"})
    List<Goods> searchGoods(@Param("goods") Goods goods);
}
