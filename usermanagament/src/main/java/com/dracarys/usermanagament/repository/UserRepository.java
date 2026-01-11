package com.dracarys.usermanagament.repository;

import com.dracarys.usermanagament.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
}
