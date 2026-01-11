package com.example.springdatajpaprac.controller;

import com.example.springdatajpaprac.dto.UserDetailsDTO;
import com.example.springdatajpaprac.entity.UserDetails;
import com.example.springdatajpaprac.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserDetailsController {

    private UserDetailsService userDetailsService;

    @Autowired
    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/user")
    public UserDetails createUserDetails(@RequestBody UserDetails userDetails) {
        return userDetailsService.save(userDetails);
    }

    @GetMapping("/user/{id}")
    public UserDetails findById(@PathVariable Long id) {
//         UserDetails userDetails = userDetailsService.findById(id);
//         userDetails.getOrderDetails().remove(0);
//         userDetailsService.save(userDetails);
//         return userDetails.toDto();
        return userDetailsService.findById(id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserDetails(@PathVariable Long id) {
//        userDetailsService.delete(id);
    }
}
