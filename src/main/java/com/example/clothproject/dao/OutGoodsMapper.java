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

    @Select("select * from outgoods where adminname = #{name}")
    List<OutGoods> searchOutGoods(@Param("name") String adminname);
}
