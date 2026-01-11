package com.project.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Hello {

    // field based autowiring
//    @Autowired
    private Computer conn;


    // constructor based autowiring
    @Autowired
    public Hello(@Qualifier("laptop") Computer conn) {
        this.conn = conn;
    }

    public String hello()  {
        conn.compile();
        System.out.println("Hello world!");
        return "hello";
    }
}
