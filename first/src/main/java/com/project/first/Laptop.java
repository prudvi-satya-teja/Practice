package com.project.first;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

    public void compile() {
        System.out.println("comiling at laptop class");
    }
}
