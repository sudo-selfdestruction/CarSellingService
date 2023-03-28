package com.CarSellingService.controller;

import com.CarSellingService.entity.User;
import com.CarSellingService.repository.UserRepository;
import com.CarSellingService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signUp.html")
    public String signUp(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("title", "Sign up to JDM");
        return "signUp";
    }

    @PostMapping("/signUp.html")
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "signUp";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "signUp";
        }

        UserService userService = null;

        if (!userService.saveUser(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "signUp";
        }

        return "redirect:/";
    }
}
