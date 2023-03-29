package com.CarSellingService.controller;

import com.CarSellingService.entity.User;
import com.CarSellingService.repository.UserRepository;
import com.CarSellingService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/signUp.html")
    public String signUp(Model model) {
//        model.addAttribute("userForm", new User());
        model.addAttribute("title", "Sign up to JDM");
        return "signUp";
    }

    @PostMapping("/signUp.html")
    public String addUser(@ModelAttribute("userForm") User userForm,
                          @RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("passwordConfirm") String passwordConfirm,
                          BindingResult bindingResult, Model model) {

        System.out.println(username + " sad ");
        userForm.setUsername(username);
        userForm.setPassword(password);
        userForm.setPasswordConfirm(passwordConfirm);

        if (bindingResult.hasErrors()) {
            return "signUp";
        }
        if (!Objects.equals(password, passwordConfirm)) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "signUp";
        }

        UserService userService = new UserService(userRepository);

        if (!userService.saveUser(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "signUp";
        }
        userService.saveUser(userForm);

        return "redirect:/";
    }
}
