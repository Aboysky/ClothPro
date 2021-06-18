package com.example.clothproject.dao;

import com.example.clothproject.entity.OutGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OutGoodsMapper {

    @Select("select * from outgoods")
    List<OutGoods> listOutGoods();

    @Select({"<script>",
            "SELECT * FROM outgoods",
            "WHERE 1=1 ",
            "<when test='goods.adminId!=null'>",
            "AND adminId = #{goods.adminId}",
            "</when>",
            "<when test='goods.goodsId!=null'>",
            "AND goodsId = #{goods.goodsId}",
            "</when>",
            "<when test='goods.adminName!=null'>",
            "AND adminName = #{goods.adminName}",
            "</when>",
            "<when test='goods.goodsName!=null'>",
            "AND goodsName = #{goods.goodsName}",
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
    List<OutGoods> searchOutGoods(@Param("good") OutGoods outGoods);
}
