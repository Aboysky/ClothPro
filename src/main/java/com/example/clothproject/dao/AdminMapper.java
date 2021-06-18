package com.example.clothproject.dao;

import com.example.clothproject.entity.Admin;
import org.apache.ibatis.annotations.*;

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

    @Insert("insert into admin(username,password,auth) values (#{username},#{password},#{auth})")
    int register(@Param("username") String username,@Param("password") String password,@Param("auth") int auth);

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

    @Update("update admin set password = #{admin.password},auth = #{admin.auth},gender = #{admin.gender},age = #{admin.age},tel = #{admin.tel} where username = #{admin.username}")
    Admin updateAdmin(@Param("admin") Admin admin);

    @Delete("delete from admin where username = #{admin.username}")
    int deleteAdmin(@Param("admin") Admin admin);
}
