package com.example.sprintdatajpamanytomany.controller;
import com.example.sprintdatajpamanytomany.entity.OrderDetails;
import com.example.sprintdatajpamanytomany.entity.ProductDetails;
import com.example.sprintdatajpamanytomany.service.OrderDetailsService;
import com.example.sprintdatajpamanytomany.service.ProductDetailsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/order")
public class OrderDetailsController {

    private OrderDetailsService orderDetailsService;

    private ProductDetailsService productDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService,  ProductDetailsService productDetailsService) {
        this.orderDetailsService = orderDetailsService;
        this.productDetailsService = productDetailsService;
    }

    @PostMapping("")
    public OrderDetails save(@RequestBody OrderDetails orderDetails) {
        List<ProductDetails> productDetails = orderDetails.getProductDetails().stream()
                .map((product -> productDetailsService.findById(product.getProductId())))
                .collect(Collectors.toList());
        orderDetails.setProductDetails(productDetails);
        return orderDetailsService.save(orderDetails);
    }

    @GetMapping("/{id}")
    public OrderDetails findById(@PathVariable Long id) {
        return orderDetailsService.findById(id);
    }
}
