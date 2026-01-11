package com.dracarys.springdatajpa.controller;


import com.dracarys.springdatajpa.repository.AddressRepository;
import com.dracarys.springdatajpa.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    AddressService addressService;

    @Autowired
    AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
}


