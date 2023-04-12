package com.CarSellingService.controller;

import com.CarSellingService.entity.User;
import com.CarSellingService.repository.UserRepository;
import com.CarSellingService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.logging.Logger;


@RestController
public class AuthController {
    private Logger logger = Logger.getLogger(AuthController.class.getName());
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signUp")
    public void blank(){

    }
    @PostMapping("/signUp")
    public User addUser(@RequestBody User userForm) {

        UserService userService = new UserService(userRepository);

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
