package com.example.clothproject.dao;

import com.example.clothproject.entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Classname AdminMapper
 * @Description TODO
 * @Date 2021/6/16 23:21
 * @Created by Huan
 */
@Mapper
public interface AdminMapper {

    @Select("select * from admin where username = #{name}")
    Admin login(@Param("name") String username);

    @Insert("insert into admin(username,password) values (#{username},#{password})")
    int register(@Param("username") String username,@Param("password")String password);

    @Select("select * from admin")
    List<Admin> listAdmins();



}
