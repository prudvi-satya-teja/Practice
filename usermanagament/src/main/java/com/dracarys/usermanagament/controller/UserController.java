package com.dracarys.usermanagament.controller;

import com.dracarys.usermanagament.entity.UserDetails;
import com.dracarys.usermanagament.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public UserDetails save(@RequestBody UserDetails userDetails) {
        return userService.save(userDetails);
    }

    @PutMapping("/{id}")
    public UserDetails update(@RequestBody UserDetails userDetails, @PathVariable Long id) {
        return userService.update(userDetails, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
         userService.delete(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public UserDetails findById(@PathVariable Long id) {
        return userService.findById(id);
    }
}

