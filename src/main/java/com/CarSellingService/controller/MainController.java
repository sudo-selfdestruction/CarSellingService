package com.CarSellingService.controller;

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

    @GetMapping("/user")
    public String user() {
        return "home";
    }
    @GetMapping("/admin")
    public String admin() {
        return "home";
    }


}
