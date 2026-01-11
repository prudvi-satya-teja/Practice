package com.example.derivedqueries.controller;


import com.example.derivedqueries.dto.UserDTO;
import com.example.derivedqueries.entity.UserDetails;
import com.example.derivedqueries.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserDetailsController {

    UserDetailsService userDetailsService;

    @Autowired
    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @PostMapping("/users")
    public UserDetails save(@RequestBody UserDetails userDetails) {
        return userDetailsService.save(userDetails);
    }

    @GetMapping("/users/{id}")
    public UserDetails findById(@PathVariable Long id) {
        return userDetailsService.findById(id);
    }

    @GetMapping("/users")
    public List<UserDetails> findByName(@RequestParam String name) {
        return userDetailsService.findByName(name);
    }

    @DeleteMapping("/users")
    public void deleteByName(@RequestParam String name) {
         userDetailsService.deleteByName(name);
    }


}
