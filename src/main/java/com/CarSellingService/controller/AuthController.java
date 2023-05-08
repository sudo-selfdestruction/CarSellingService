package com.CarSellingService.controller;

import com.CarSellingService.entity.User;
import com.CarSellingService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.logging.Logger;

@RestController
public class AuthController {
    private Logger logger = Logger.getLogger(AuthController.class.getName());
    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public User addUser(@RequestBody User userForm) {


        if (!userService.saveUser(userForm)) {
            logger.info("Пользователь с таким именем уже существует");
            return null;
        }
        if (!Objects.equals(userForm.getPassword(), userForm.getPasswordConfirm())) {
            logger.info("Пароли не совпадают");
            return null;
        }

        userService.saveUser(userForm);
        return userForm;
    }
}

