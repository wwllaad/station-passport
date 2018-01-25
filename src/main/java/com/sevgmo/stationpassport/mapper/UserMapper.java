package com.sevgmo.stationpassport.mapper;

import com.sevgmo.stationpassport.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

}
