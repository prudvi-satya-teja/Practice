package com.dracarys.customInterceptor.service;


import com.dracarys.customInterceptor.annotations.MyCustomAnnotation;
import com.dracarys.customInterceptor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @MyCustomAnnotation
    public void getUser() {
        System.out.println("get user method is executing in the service layer");
    }
}
