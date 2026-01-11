package com.dracarys.usermanagament.service;


import com.dracarys.usermanagament.entity.UserAddress;
import com.dracarys.usermanagament.repository.UserAddressRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAddressService {

    UserAddressRepository userAddressRepository;

    public UserAddressService(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }


    public UserAddress get(Long id) {
        return userAddressRepository.findById(id).orElse(null);
    }
}
