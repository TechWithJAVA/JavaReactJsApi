package com.java.yash.reactjsapi.controller.service;

import com.java.yash.reactjsapi.model.User;

import java.util.List;

public interface UserService {

    String createUser(User user);

    List<User> getUsers();

    String updateUser(User user,int id);

    String deleteUser(int id);
}
