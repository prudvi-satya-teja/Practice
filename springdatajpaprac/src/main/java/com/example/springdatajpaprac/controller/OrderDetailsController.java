package com.example.springdatajpaprac.controller;

import com.example.springdatajpaprac.entity.OrderDetails;
import com.example.springdatajpaprac.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping("/order/{id}")
    public OrderDetails getOrderDetails(@PathVariable Long id) {
        return orderDetailsService.findById(id);
    }

    @PostMapping("/order")
    public OrderDetails saveOrderDetails(@RequestBody OrderDetails orderDetails) {
        System.out.println("Order details is " + orderDetails);
        return orderDetailsService.save(orderDetails);
    }
}
