package com.dracarys.security.controller;


import com.dracarys.security.entity.UserAuthEntity;
import com.dracarys.security.service.UserAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    UserAuthService userAuthService;

    PasswordEncoder passwordEncoder;

    public UserAuthController(UserAuthService userAuthService, PasswordEncoder passwordEncoder) {
        this.userAuthService = userAuthService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserAuthEntity userAuthDetails) {
        userAuthDetails.setPassword(passwordEncoder.encode(userAuthDetails.getPassword()));

        userAuthService.save(userAuthDetails);

        List<UserAuthEntity> users = userAuthService.findAll();
        users.stream().forEach((user) -> {
            System.out.println(user);
        })        ;

        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

}
