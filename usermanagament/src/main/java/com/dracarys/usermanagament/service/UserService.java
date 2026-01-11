package com.dracarys.usermanagament.service;

import com.dracarys.usermanagament.entity.UserDetails;
import com.dracarys.usermanagament.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userDetailsRepository) {
        this.userRepository = userDetailsRepository;
    }

    public UserDetails save(UserDetails userDetails) {
        return  userRepository.save(userDetails);
    }

    public UserDetails update(UserDetails userDetails, Long id) {
        Optional<UserDetails> userInfo = userRepository.findById(id);
        if(userInfo.isPresent()) {
            return userRepository.save(userDetails);
        }
        return null;
    }

    public void delete(Long id) {
        Optional<UserDetails> userInfo = userRepository.findById(id);
        userInfo.ifPresent(userDetails -> userRepository.delete(userDetails));
    }

    public UserDetails findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}

