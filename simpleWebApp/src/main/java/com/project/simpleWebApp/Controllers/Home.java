package com.project.simpleWebApp.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @RequestMapping("/")
    public String hello() {
        return "Hello World!!!";
    }

    @RequestMapping("/about")
    public String about() {
        return "It is about Page";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "It is contact Page";
    }

    @RequestMapping("/Adil-Khan")
    public String AdilKhan() {
        return "This is Adil Khan";
    }

}
