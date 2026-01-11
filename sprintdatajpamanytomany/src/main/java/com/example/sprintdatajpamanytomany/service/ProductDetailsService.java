package com.example.sprintdatajpamanytomany.service;

import com.example.sprintdatajpamanytomany.entity.ProductDetails;
import com.example.sprintdatajpamanytomany.repository.ProductDetailsRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsService {
    private ProductDetailsRepository productDetailsRepository;

    @Autowired
    public ProductDetailsService(ProductDetailsRepository productDetailsRepository) {
        this.productDetailsRepository = productDetailsRepository;
    }

    public ProductDetails save(ProductDetails productDetails) {
        return productDetailsRepository.save(productDetails);
    }

    public ProductDetails findById(Long productId) {
        return  productDetailsRepository.findById(productId).orElse(null);
    }
}
