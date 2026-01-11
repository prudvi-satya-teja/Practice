package com.project.simpleWebApp.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {

    @RequestMapping("/m")
    public String getName() {
        return "My name is Prudvi";
    }
}



