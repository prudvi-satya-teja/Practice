package com.example.derivedqueries.service;

import com.example.derivedqueries.entity.UserDetails;
import com.example.derivedqueries.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService {
    UserDetailsRepository userDetailsRepository;

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

    public List<UserDetails> findByName(String name) {
        Sort sort = Sort.by(
                Sort.Order.asc("name"),
                Sort.Order.desc("email")
        );
        Pageable pageable = PageRequest.of(0, 5, sort);
        return   userDetailsRepository.findUserDetailsByName(name, pageable);
    }

    public void deleteByName(String name) {
        Optional<UserDetails> user = userDetailsRepository.findById(1L);
        userDetailsRepository.deleteUserDetailsByName(name);
        Optional<UserDetails> userDetails = userDetailsRepository.findById(1L);
        System.out.println(userDetails.isPresent() + " present or not");
    }
}


