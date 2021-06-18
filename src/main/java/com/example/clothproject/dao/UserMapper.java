package com.example.clothproject.dao;

import com.example.clothproject.entity.User;
import com.example.clothproject.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 2021/6/16 22:56
 * @Created by Huan
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USER WHERE NAME = #{name} and password = #{password}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Select("select id,name,age,tel from user")
    List<User> listUsers();

    @Select({"<script>",
            "SELECT * FROM user",
            "WHERE 1=1 ",
            "<when test='goods.id!=null'>",
            "AND id = #{goods.id}",
            "</when>",
            "<when test='goods.name!=null'>",
            "AND name = #{goods.name}",
            "</when>",
            "<when test='goods.age!=null'>",
            "AND age = #{goods.age}",
            "</when>",
            "<when test='goods.tel!=null'>",
            "AND tel = #{goods.tel}",
            "</when>",
            "</script>"})
    List<User> searchUsers(@Param("goods") User user);


    @Update("update user set name = #{user.name},age = #{user.age},tel = #{user.tel} where id = #{user.id} ")
    User updateUser(@Param("user") User user);

    @Delete("delete from user where id = #{user.id}")
    int deleteUser(@Param("user") User user);
}
