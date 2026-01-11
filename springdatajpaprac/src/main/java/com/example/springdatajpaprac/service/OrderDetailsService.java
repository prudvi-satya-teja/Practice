package com.example.springdatajpaprac.service;

import com.example.springdatajpaprac.entity.OrderDetails;
import com.example.springdatajpaprac.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public OrderDetails findById(Long id) {
        return orderDetailsRepository.findById(id).orElse(null);
    }

    public OrderDetails save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }
}
