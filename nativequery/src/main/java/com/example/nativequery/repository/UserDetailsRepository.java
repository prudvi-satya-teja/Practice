package com.example.nativequery.repository;

import com.example.nativequery.dto.UserDetailsDTO;
import com.example.nativequery.entity.UserDetails;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>, JpaSpecificationExecutor<UserDetails> {

//    @Query(value = "Select u.user_name, u.user_email from user_datails u where u.user_name = :userName", nativeQuery = true)
    @Query(name="userDetailsVal", nativeQuery=true)
    List<UserDetailsDTO> findByUserName(@Param(value = "userName") String userName);
}
