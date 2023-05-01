package com.CarSellingService.controller;

import com.CarSellingService.entity.User;
import com.CarSellingService.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AdminController {
    private UserService userService;

    @GetMapping("/admin/user/{id}")
    public User getUserById(@PathVariable("id") User user) {
        return userService.findUserById(user.getId());
    }
}
