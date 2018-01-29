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
public class RestController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    private List<User> getAllUsersFromDB() {
        return userService.getAllUsersFromDB();
    }

    @GetMapping("/user")
    private User getUserById(@RequestParam int id){
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    private void AddUserToDB(@RequestParam String username, String password, String email, String phone, String role){
        userService.AddUserToDB(username,password,email,phone,role);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    private void deleteUserFromDB(@RequestParam int id){
        userService.deleteUserFromDB(id);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    private void updateUserInDB(@RequestParam int id, String email, String phone) {
        userService.updateUserInDB(id, email, phone);
    }








//    @RequestMapping(method = RequestMethod.POST, value = "/add")
//    private List<User> add(@RequestParam String username, String password, String email, String phone, String role) {
//
//        userService.addUserToDB(username,password,email,phone,role);
//
//        return userService.getAllFromDB();
//    }
//
//    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
//    private List<User> update(@RequestParam int id, String email, String phone) {
//
//        userService.updateUserInDB(id,email,phone);
//
//        return userService.getAllFromDB();
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
//    private List<User> delete(@RequestParam int id) {
//
//        userService.deleteUserFromDB(id);
//
//        return userService.getAllFromDB();
//    }

}

