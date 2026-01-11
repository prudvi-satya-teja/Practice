package com.project.simpleWebApp.Controllers;

import com.project.simpleWebApp.Models.Product;
import com.project.simpleWebApp.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable int  productId) {
        return service.getProductById(productId);
    }

    @PostMapping("/add-product")
    public void addProduct(@RequestBody Product product) {
        System.out.println("My product is: " + product);
        service.addProduct(product);
    }

    @PutMapping("/update-product")
    public void updateProduct(@RequestBody Product product) {
        service.updateProduct(product);
    }

    @DeleteMapping("/delete-product/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        service.deleteProduct(productId);
    }
}



