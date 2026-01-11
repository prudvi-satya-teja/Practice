package com.dracarys.jwtauthpractice.controller;


import com.dracarys.jwtauthpractice.entity.UserAuth;
import com.dracarys.jwtauthpractice.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserAuthController {

    private final UserAuthService userAuthService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserAuthController(UserAuthService userAuthService, PasswordEncoder passwordEncoder) {
        this.userAuthService = userAuthService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/users")
    public ResponseEntity<String> hello() {
        return ResponseEntity.status(HttpStatus.OK).body("hello");
    }

    @PostMapping("/register-user")
    public ResponseEntity<String> registerUser(@RequestBody UserAuth userAuth) {
        userAuth.setPassword(passwordEncoder.encode(userAuth.getPassword()));
        System.out.println(userAuth.getPassword());
        userAuthService.save(userAuth);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
}
