package com.dracarys.customInterceptor.controller;

import com.dracarys.customInterceptor.entity.UserDetails;
import com.dracarys.customInterceptor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public UserDetails getUser() {
        UserDetails user = new UserDetails();
        System.out.println("get user method is executing");
//
//        userService.getUser();

        return user;
    }

}


