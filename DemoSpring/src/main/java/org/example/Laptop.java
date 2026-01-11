package org.example;

public class Laptop implements Computer {

    Laptop() {
        System.out.println("Laptop Constructor");
    }

    public void work() {
        System.out.println("I am working on an application in the laptop");
    }

}
