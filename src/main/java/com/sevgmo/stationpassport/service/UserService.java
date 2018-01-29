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

    public List<User> getAllUsersFromDB(){
        List<User> users = sqlSession.selectList("getAllUsersFromDB");
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

    public void AddUserToDB(User user){
        sqlSession.insert("AddUserToDB", user);
    }

    public void AddUserToDB(String username, String password, String email, String phone, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);
        sqlSession.insert("AddUserToDB", user);
    }

    public void deleteUserFromDB(int id){
        sqlSession.delete("deleteUserFromDB", id);
    }

    public void updateUserInDB(int id, String email, String phone){
        User user = new User();
        user.setId(id);
        user.setPhone(email);
        user.setEmail(phone);
        sqlSession.update("updateUserInDB", user);
    }
}




//    @Autowired
//    private UserMapper userMapper;
//
//    public void addUserToDB(User user){
//        userMapper.add(user);
//    }
//
//    public void addUserToDB(String username, String password, String email, String phone, String role){
//
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setEmail(email);
//        user.setPhone(phone);
//        user.setRole(role);
//        userMapper.add(user);
//    }
//
//    public List<User> getAllFromDB(){
//
//        return userMapper.getAll();
//    }
//
//    public User getUserById(int id){
//        User user = userMapper.getUserById(id);
//        return user;
//    }
//
//    public void deleteUserFromDB(int id){
//        userMapper.delete(id);
//    }
//
//    public void updateUserInDB(int id, String email, String phone){
//        User user = new User();
//        user.setId(id);
//        user.setPhone(email);
//        user.setEmail(phone);
//        userMapper.update(user);
//    }
