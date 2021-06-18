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

    @Select({"<script>",
            "SELECT * FROM admin",
            "WHERE 1=1 ",
            "<when test='goods.username!=null'>",
            "AND username = #{goods.username}",
            "</when>",
            "<when test='goods.password!=null'>",
            "AND password = #{goods.password}",
            "</when>",
            "<when test='goods.auth!=null'>",
            "AND auth = #{goods.auth}",
            "</when>",
            "<when test='goods.gender!=null'>",
            "AND gender = #{goods.gender}",
            "</when>",
            "<when test='goods.age!=null'>",
            "AND age = #{goods.age}",
            "</when>",
            "<when test='goods.tel!=null'>",
            "AND tel = #{goods.tel}",
            "</when>",
            "</script>"})
    List<Admin> searchAdmins(@Param("goods") Admin admin);


}
