package com.sevgmo.stationpassport.service;


import com.sevgmo.stationpassport.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final SqlSession sqlSession;

    public UserService(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<User> getAllUsers(){
        List<User> users = sqlSession.selectList("getAllUsers");
        return users;
    }

    public User getUserById(int id){
        return sqlSession.selectOne("getUserById",id);
    }


    public String getPasswordByUsername(String username){
        return sqlSession.selectOne("getPasswordByUsername", username);
    }

    public String getRoleByUsername(String username){
        return sqlSession.selectOne("getRoleByUsername", username);
    }

    public String  getUsernameById(int id){
        return sqlSession.selectOne("getUsernameById", id);
    }

    public void AddUser(User user){
        sqlSession.insert("AddUser", user);
    }

    public void AddUser(String username, String password, String email, String phone, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);
        sqlSession.insert("AddUser", user);
    }

    public void deleteUser(int id){
        sqlSession.delete("deleteUser", id);
    }

    public void updateUser(int id, String email, String phone){
        User user = new User();
        user.setId(id);
        user.setPhone(email);
        user.setEmail(phone);
        sqlSession.update("updateUser", user);
    }
}

