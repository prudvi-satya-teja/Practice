package com.dracarys.jwtauthpractice.service;


import com.dracarys.jwtauthpractice.entity.UserAuth;
import com.dracarys.jwtauthpractice.repository.UserAuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {

    private final UserAuthRepository userAuthRepository;

    public UserAuthService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername : " + username);
        return userAuthRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public void save(UserAuth userAuth) {
        userAuthRepository.save(userAuth);
    }
}
