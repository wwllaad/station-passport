package com.sevgmo.stationpassport.mapper;

import com.sevgmo.stationpassport.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users")
    List<User> getAll();

    @Insert("INSERT INTO users(username,password,email,phone,role) VALUES(#{username},#{password},#{email},#{phone},#{role})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void add(User user);

    @Update("UPDATE users SET phone=#{phone}, email=#{email} where id=#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id=#{id}")
    void delete(User user);

    @Select("SELECT password FROM users WHERE username=#{username}")
    String getPasswordByUsername(String username);

    @Select("SELECT role FROM users WHERE username=#{username}")
    String getRoleByUsername(String username);

    @Select("SELECT username FROM users WHERE id=#{id}")
    String getUsernameById(int id);

}
