package com.CarSellingService.controller;

import com.CarSellingService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signUp.html")
    public String signUp(Model model) {
        model.addAttribute("title", "Sign up to JDM");
        return "signUp";
    }

}
