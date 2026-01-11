package com.example.sprintdatajpamanytomany.repository;

import com.example.sprintdatajpamanytomany.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {
}
