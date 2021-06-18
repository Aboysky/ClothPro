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

    @Select("select * from goods where name = #{name}")
    List<Goods> searchGoods(@Param("name") String name);
}
