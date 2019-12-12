package com.java.yash.reactjsapi.controller.service;

import com.java.yash.reactjsapi.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService{

    List<User> listUsers=new ArrayList<>();

    @Override
    public String createUser(User user) {
        if(!listUsers.isEmpty()) {
            if (getUserId(user)) {
                listUsers.add(user);
                return "Created Successfully";
            } else
                return "Already Exist";
        }else
            listUsers.add(user);
        return "Created Successfully";
    }
    private Boolean getUserId(User user) {
        for (User use : listUsers) {
            if (use.getId()!=(user.getId())) {
                return true;
            } else
                return false;
        }
        return false;
    }
    @Override
    public List<User> getUsers() {
        return listUsers;
    }

    @Override
    public String updateUser(User user,int id) {
        User use=findId(id);
        if(!StringUtils.isEmpty(user)) {
          int index = listUsers.indexOf(use);
            System.out.println(index);
            listUsers.set(index, user);
            //OR
           /*listUsers.remove(use);
            if (!Objects.isNull(user.getId()))
                use.setId(user.getId());
            if (!Objects.isNull(user.getName()))
                use.setName(user.getName());
            if (!Objects.isNull(user.getPhoneNumber()))
                use.setPhoneNumber(user.getPhoneNumber());
            if (!Objects.isNull(user.getEmail()))
                use.setEmail(user.getEmail());
            listUsers.add(use);*/
            return "Id Successfully updated";
        }
        return "Updated UnSuccessfully";
    }

    private User findId(int id) {
        User user = listUsers.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0);
       return  user;
    }

    @Override
    public String deleteUser(int id) {
        if(!listUsers.isEmpty()){
            Predicate<User> condition = user -> user.getId()==id;
            listUsers.removeIf(condition);
            return "deleted Successfully";
        }
        return "deleted UnSuccessfully";
    }

}
