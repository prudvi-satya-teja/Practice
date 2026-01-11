package com.example.sprintdatajpamanytomany.service;

import com.example.sprintdatajpamanytomany.entity.OrderDetails;
import com.example.sprintdatajpamanytomany.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public OrderDetails save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    public OrderDetails findById(Long id) {
        return orderDetailsRepository.findById(id).orElse(null);
    }
}
