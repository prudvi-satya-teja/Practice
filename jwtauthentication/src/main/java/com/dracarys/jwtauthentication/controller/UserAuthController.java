package com.dracarys.jwtauthentication.controller;

import com.dracarys.jwtauthentication.entity.UserAuth;
import com.dracarys.jwtauthentication.service.UserAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAuthController {

    private final UserAuthService userAuthService;
    private final PasswordEncoder passwordEncoder;

    public UserAuthController(UserAuthService userAuthService, PasswordEncoder passwordEncoder) {
        this.userAuthService = userAuthService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users")
    public String hello() {
        return "hello";
    }

    @PostMapping("/user-register")
    public ResponseEntity<String> saveUser(@RequestBody UserAuth userAuth) {
        userAuth.setPassword(passwordEncoder.encode(userAuth.getPassword()));
        userAuthService.save(userAuth);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully");
    }


}
