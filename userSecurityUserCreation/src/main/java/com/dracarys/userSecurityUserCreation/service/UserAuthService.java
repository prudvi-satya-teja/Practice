package com.dracarys.userSecurityUserCreation.service;


import com.dracarys.userSecurityUserCreation.entity.UserAuthEntity;
import com.dracarys.userSecurityUserCreation.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthService implements UserDetailsService {

    UserAuthRepository userAuthRepository;

    @Autowired
    public UserAuthService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void save(UserAuthEntity userAuthEntity) {
        userAuthRepository.save(userAuthEntity);
    }

    public List<UserAuthEntity> findAll() {
        return userAuthRepository.findAll();
    }
}
