package com.example.hibernateLogin.services;

import com.example.hibernateLogin.models.User;
import com.example.hibernateLogin.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServices {

    @Autowired
    private UserRepositories userRepository;

    public List<User> userList() {
        return userRepository.findAll();
    }
}
