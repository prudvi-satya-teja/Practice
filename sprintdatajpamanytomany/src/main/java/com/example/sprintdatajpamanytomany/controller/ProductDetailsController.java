package com.example.sprintdatajpamanytomany.controller;

import com.example.sprintdatajpamanytomany.entity.ProductDetails;
import com.example.sprintdatajpamanytomany.service.ProductDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
        @RequestMapping("/api")
public class ProductDetailsController {

    private ProductDetailsService productDetailsService;

    public ProductDetailsController(ProductDetailsService productDetailsService) {
        this.productDetailsService = productDetailsService;
    }

    @PostMapping("/products")
    public ProductDetails save(@RequestBody ProductDetails productDetails) {
        return productDetailsService.save(productDetails);
    }
}
