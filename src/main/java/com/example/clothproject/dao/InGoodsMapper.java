package com.example.clothproject.dao;

import com.example.clothproject.entity.InGoods;
import com.example.clothproject.entity.InGoods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InGoodsMapper {
    @Select("select * from ininInGoods")
    List<InGoods> listInGoods();

    @Select({"<script>",
            "SELECT * FROM ininInGoods",
            "WHERE 1=1 ",
            "<when test='inInGoods.adminId!=null'>",
            "AND adminId = #{inInGoods.adminId}",
            "</when>",
            "<when test='inInGoods.inInGoodsId!=null'>",
            "AND inInGoodsId = #{inInGoods.inInGoodsId}",
            "</when>",
            "<when test='inInGoods.adminName!=null'>",
            "AND adminName = #{inInGoods.adminName}",
            "</when>",
            "<when test='inInGoods.inInGoodsName!=null'>",
            "AND inInGoodsName = #{inInGoods.inInGoodsName}",
            "</when>",
            "<when test='inInGoods.size!=null'>",
            "AND size = #{inInGoods.size}",
            "</when>",
            "<when test='inInGoods.amount!=null'>",
            "AND amount = #{inInGoods.amount}",
            "</when>",
            "<when test='inInGoods.date!=null'>",
            "AND date = #{inInGoods.date}",
            "</when>",
            "<when test='inInGoods.factory!=null'>",
            "AND factory = #{inInGoods.factory}",
            "</when>",
            "</script>"})
    List<InGoods> searchInGoods(@Param("inInGoods") InGoods inInGoods);

    @Update("update ingoods set adminName = #{inInGoods.adminName},goodsName  = #{inInGoods.goodsName },size  = #{inInGoods.size },amount  = #{inInGoods.amount },date = #{inInGoods.date},factory = #{inInGoods.factory} where adminId = #{inInGoods.adminId} and goodsId = #{inInGoods.goodsId}")
    InGoods updateInGoods(@Param("inInGoods") InGoods inInGoods);

    @Delete("delete from ingoods where adminId = #{inInGoods.adminId} and goodsId = #{inInGoods.goodsId}")
    int deleteInGoods(@Param("inInGoods") InGoods inInGoods);
    
}
