package com.example.springdatajpaprac.dto;

import com.example.springdatajpaprac.entity.OrderDetails;
import lombok.Data;

import java.util.List;

@Data
public class UserDetailsDTO {
    private Long id;
    private String name;

    private List<OrderDetails> orderDetails;


}

