package com.example.hibernateLogin.services;

import com.example.hibernateLogin.models.User;

public interface UserService {
    void save(User user);

    User findByName(String name);
}
