package com.project.simpleWebApp.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    private int id;
    private String name;
    private String phoneNo;
    private String email;

    public Customer() {

    }

    public Customer (int id, String name, String phoneNo, String email) {
        this.id = id;
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }


    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}