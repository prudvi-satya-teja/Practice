package com.dracarys.userSecurityUserCreation.controller;


import com.dracarys.userSecurityUserCreation.entity.UserAuthEntity;
import com.dracarys.userSecurityUserCreation.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class UserAuthController {

    UserAuthService userAuthService;

    PasswordEncoder passwordEncoder;

    @Autowired
    public UserAuthController(UserAuthService userAuthService, PasswordEncoder passwordEncoder) {
        this.userAuthService = userAuthService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/register")
    public ResponseEntity<String> save(@RequestBody UserAuthEntity userAuthEntity) {
        userAuthEntity.setPassword(passwordEncoder.encode(userAuthEntity.getPassword()));
        userAuthService.save(userAuthEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Registered Successfully");
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserAuthEntity>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userAuthService.findAll());
    }
}
