package com.example.hibernateLogin.controllers;

import com.example.hibernateLogin.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HibernateController {

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
