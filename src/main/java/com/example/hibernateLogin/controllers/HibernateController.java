package com.example.hibernateLogin.controllers;

import com.example.hibernateLogin.models.User;
import com.example.hibernateLogin.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HibernateController {

    @Autowired
    UserRepositories userRepository;

    @PostMapping("/signUpUser")
    String signUpUser (User user, Model model) {
        model.addAttribute(user);
        userRepository.save(user);
        return "success";
    }

    @PostMapping("/login")
    String loginUser(User user, Model model){
        model.addAttribute(user);
        if (user.getEmail().equals("piet@gmail.com") && user.getPassword().equals("geheim")) {
            return "success";
        } else {
            return "nosuccess";
        }
    }

    @GetMapping("/index")
    String jumpToForm() {
        return "index";
    }

    @GetMapping("/signin")
    String jumpToSignIn() {
        return "signin";
    }
}
