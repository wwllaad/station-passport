package com.sevgmo.stationpassport.controller;

import com.sevgmo.stationpassport.mapper.UserMapper;
import com.sevgmo.stationpassport.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/users")
public class RestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/all")
    private List<User> getAll() {
        return userMapper.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    private List<User> add(@RequestParam String username, String password, String email, String phone, String role) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);

        userMapper.add(user);

        return userMapper.getAll();
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    private List<User> update(@RequestParam int id, String email, String phone) {

        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setPhone(phone);
        userMapper.update(user);

        return userMapper.getAll();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    private List<User> delete(@RequestParam int id) {

        User user = new User();
        user.setId(id);

        userMapper.delete(user);

        return userMapper.getAll();
    }

}

