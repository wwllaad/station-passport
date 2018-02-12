package com.sevgmo.stationpassport.controller;

import com.sevgmo.stationpassport.model.User;
import com.sevgmo.stationpassport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    private List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user")
    private User getUserById(@RequestParam int id){
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    private void AddUser(@RequestParam String username, String password, String email, String phone, String role){
        userService.AddUser(username,password,email,phone,role);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    private void deleteUser(@RequestParam int id){
        userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    private void updateUser(@RequestParam int id, String email, String phone) {
        userService.updateUser(id, email, phone);
    }
}

