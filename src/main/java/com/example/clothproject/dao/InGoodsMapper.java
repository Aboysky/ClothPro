package com.example.clothproject.dao;

import com.example.clothproject.entity.InGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InGoodsMapper {
    @Select("select * from ingoods")
    List<InGoods> listInGoods();

    @Select("select * from ingoods where adminname = #{name}")
    List<InGoods> searchInGoods(@Param("name") String adminname);
}
