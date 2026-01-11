package com.example.demo.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
