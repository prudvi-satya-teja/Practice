package com.dracarys.usermanagament.repository;


import com.dracarys.usermanagament.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress,Long> {
}
