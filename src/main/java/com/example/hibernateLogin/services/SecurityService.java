package com.example.hibernateLogin.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String name, String password);
}
