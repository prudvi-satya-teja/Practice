package com.example.DemoApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping("/")
    public String sayHome() {
        return "Hello World! This is Home Page";
    }

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello! This is Hello Page";
    }
}
