package com.example.springdatajpaprac.entity;

import com.example.springdatajpaprac.dto.UserDetailsDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_details")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name="user_name")
    private String name;

    @OneToMany(mappedBy = "userDetails", cascade=CascadeType.ALL)
            @JsonManagedReference
    List<OrderDetails> orderDetails;

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
        for(OrderDetails orderDetails1 : orderDetails) {
            orderDetails1.setUserDetails(this);
        }
    }

    public UserDetailsDTO toDto() {
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setId(this.getId());
        userDetailsDTO.setName(this.getName());
        System.out.println("fetching order from db");
        System.out.println(this);
        userDetailsDTO.setOrderDetails(this.getOrderDetails());
        return userDetailsDTO;
    }

}

