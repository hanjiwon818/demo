package com.example.demo.apply.action;

import com.example.demo.apply.entity.UserEntity;
import com.example.demo.apply.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserAction {

    @Autowired
    private UserService userService;

    public List<UserEntity> viewAllUsers() {
        return userService.getAllUsers();
    }

    public UserEntity createUser(UserEntity user) {
        return userService.createUser(user);
    }

    public UserEntity updateUser(Long id, UserEntity user) {
        return userService.updateUser(id, user);
    }

    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userService.getUserById(id);
    }
}
