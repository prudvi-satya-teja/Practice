package com.dracarys.userSecurityUserCreation.repository;


import com.dracarys.userSecurityUserCreation.entity.UserAuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuthEntity, Long> {

    Optional<UserDetails> findByUsername(String username);

}
