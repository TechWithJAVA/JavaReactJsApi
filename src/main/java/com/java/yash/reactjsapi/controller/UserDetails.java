package com.java.yash.reactjsapi.controller;

import com.java.yash.reactjsapi.controller.service.UserService;
import com.java.yash.reactjsapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserDetails {

    @Autowired
    private UserService userService;

    @GetMapping("/getMessage")
    public String getMessage(){
    return "ReactJS Api";
    }


    @PostMapping("/createUser")
    public String createUser(User user){
        String msg =userService.createUser(user);
        return msg;
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUser(){
        List<User> users= userService.getUsers();
        return users;
    }

    @PutMapping("/updateUser/{id}")
    public String updateUser(@RequestBody User user,@PathVariable int id){

        String msg=userService.updateUser(user,id);
        return msg;
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        String msg=userService.deleteUser(id);
        return msg;
    }


}
