package com.sevgmo.stationpassport.service;

import com.sevgmo.stationpassport.mapper.UserMapper;
import com.sevgmo.stationpassport.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void addUserToDB(User user){
        userMapper.add(user);
    }

    public void addUserToDB(String username, String password, String email, String phone, String role){

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);
        userMapper.add(user);
    }

    public List<User> getAllFromDB(){

        return userMapper.getAll();
    }

    public User getUserById(int id){
        User user = userMapper.getUserById(id);
        return user;
    }

    public void deleteUserFromDB(int id){
        userMapper.delete(id);
    }

    public void updateUserInDB(int id, String email, String phone){
        User user = new User();
        user.setId(id);
        user.setPhone(email);
        user.setEmail(phone);
        userMapper.update(user);
    }


}
