package com.dracarys.jwtauthpractice.repository;

import com.dracarys.jwtauthpractice.entity.UserAuth;
import com.sun.jdi.LongValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, LongValue> {

    Optional<UserDetails> findByUsername(String username);
}
