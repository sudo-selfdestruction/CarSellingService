package com.CarSellingService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "JDM");
        return "home";
    }

    @GetMapping("/signUp.html")
    public String signUp(Model model) {
        model.addAttribute("title", "JDM");
        return "signUp";
    }

}
