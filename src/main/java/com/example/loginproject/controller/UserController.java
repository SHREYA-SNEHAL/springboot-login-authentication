package com.example.loginproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.loginproject.entity.User;
import com.example.loginproject.service.UserService;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    //Show Register Page
    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    //Save User
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
         return "login";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}
