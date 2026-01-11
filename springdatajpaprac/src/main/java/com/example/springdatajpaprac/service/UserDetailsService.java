package com.example.springdatajpaprac.service;

import com.example.springdatajpaprac.entity.UserDetails;
import com.example.springdatajpaprac.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService {

    private UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserDetailsService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    public UserDetails save(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    public UserDetails findById(Long id) {
        return userDetailsRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        Optional<UserDetails> userDetails= userDetailsRepository.findById(id);
        if(userDetails.isPresent()) {
            userDetailsRepository.delete(userDetails.get());
        }
    }
}
