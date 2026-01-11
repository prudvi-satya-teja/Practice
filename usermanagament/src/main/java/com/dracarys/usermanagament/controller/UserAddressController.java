package com.dracarys.usermanagament.controller;

import com.dracarys.usermanagament.entity.UserAddress;
import com.dracarys.usermanagament.service.UserAddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/addresses")
public class UserAddressController {

    UserAddressService userAddressService;

    public UserAddressController(UserAddressService userAddressService){
        this.userAddressService = userAddressService;
    }

    @GetMapping("/{id}")
    public UserAddress getAddress(@PathVariable Long id){
        return userAddressService.get(id);
    }
}
