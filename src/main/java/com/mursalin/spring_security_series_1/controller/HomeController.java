package com.mursalin.spring_security_series_1.controller;

import com.mursalin.spring_security_series_1.model.Users;
import com.mursalin.spring_security_series_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String homePage() {
        return "Inside home page";
    }

    @PostMapping("/register")
    public String register(@RequestBody Users user) {
        service.register(user);
        return "user registration successfull";
    }
}
