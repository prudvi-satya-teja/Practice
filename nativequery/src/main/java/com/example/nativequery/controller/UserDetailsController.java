package com.example.nativequery.controller;


import com.example.nativequery.entity.UserDetails;
import com.example.nativequery.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    @Autowired
    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/users")
    public UserDetails save(@RequestBody UserDetails userDetails) {
        return userDetailsService.save(userDetails);
    }

    @GetMapping("/users/{name}")
    public List<UserDetails> findOne(@PathVariable String name) {
        return userDetailsService.findByNameSpecification(name);
    }
}

