package com.example.derivedqueries.repository;


import com.example.derivedqueries.dto.UserDTO;
import com.example.derivedqueries.entity.UserDetails;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

//    @EntityGraph(attributePaths = "addressDetails")
    @Query(name = "find")
    List<UserDetails> findUserDetailsByName(String name, Pageable pageable);

    List<UserDetails> findByNameAndPhoneNumber(String name, String phoneNumber);

    List<UserDetails> findByNameOrPhoneNumber(String name, String phoneNumber);

    List<UserDetails> findByIdBetween(Long start, Long end);

    @Transactional
    List<UserDetails> deleteByName(String name);

    List<UserDetails> findByNameStartingWith(String name, Sort sort);

    @Query("select u from UserDetails u")
    List<UserDetails> findByUserName(@Param("userName") String name);

    @Query("select u from UserDetails u Join u.addressDetails ad where ad.city = :cityName")
    List<UserDetails> findByCityName(@Param("cityName") String cityName);

    @Query("select u from UserDetails u Join u.addressDetails ad where u.name = :stateName")
    List<UserDetails> findByStateName(@Param("stateName") String stateName);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Transactional
    @Query("delete  from UserDetails u where u.name = :name")
    void deleteUserDetailsByName(@Param("name") String name);
}
