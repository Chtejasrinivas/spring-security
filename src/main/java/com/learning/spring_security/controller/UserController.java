package com.learning.spring_security.controller;

import com.learning.spring_security.model.User;
import com.learning.spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @PostMapping("login")
    @PreAuthorize("hasAnyRole('ADMIN','USER','SUPER_ADMIN')")
    public String loginUser() {
        return "User logged in successfully!";
    }

    @PostMapping("register")
    @PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
    public User registerUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','SUPER_ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
