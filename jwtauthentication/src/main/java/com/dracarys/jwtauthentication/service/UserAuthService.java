package com.dracarys.jwtauthentication.service;


import com.dracarys.jwtauthentication.entity.UserAuth;
import com.dracarys.jwtauthentication.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {

    private final UserAuthRepository userAuthRepository;

    @Autowired
    public UserAuthService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    public void save(UserAuth userAuth) {
        userAuthRepository.save(userAuth);
    }

    @Override
    public UserDetails loadUserByUsername(String username)  {
        return userAuthRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

    }


}
