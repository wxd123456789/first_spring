package com.first_spring_demo.mbg.mapper;

import com.first_spring_demo.mbg.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{id}")
    User getById(@Param("id") String id);

    @Select("SELECT * FROM users WHERE name = #{name} && email= #{email} && password = #{password}")
    User getByDetail(@Param("name") String name, @Param("email") String email, @Param("password") String password);

    @Insert("INSERT INTO users (id, email, password, name, createdAt) VALUES (#{user.id}, #{user.email}, #{user.password}, #{user.name}, #{user.createdAt})")
    void insert(@Param("user") User user);

    @Select("SELECT * FROM users LIMIT #{offset}, #{maxResults}")
    List<User> getAllUsersByPageIndex(@Param("offset") int offset, @Param("maxResults") int maxResults);

    @Select("SELECT * FROM users")
    List<User> getAllUsers();
}
