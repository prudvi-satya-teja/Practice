package com.project.simpleWebApp.Services;

import com.project.simpleWebApp.Models.Product;
import com.project.simpleWebApp.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public void addProduct(Product product) {
        repo.save(product);
    }

     public List<Product> getProducts() {
       return repo.findAll();
   }

    public Product getProductById(int productId) {
        return repo.findById(productId).orElse(new Product(101, "No product", 0));
    }

    public void updateProduct(Product product) {
        repo.save(product);
    }

    public void deleteProduct(int productId) {
        repo.deleteById(productId);
    }
}


