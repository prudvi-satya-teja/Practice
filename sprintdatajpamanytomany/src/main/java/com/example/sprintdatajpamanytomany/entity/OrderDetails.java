package com.example.sprintdatajpamanytomany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders_table")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_product_table",
            joinColumns = { @JoinColumn(name="order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="product_id", referencedColumnName = "productId")}
    )
    List<ProductDetails> productDetails;
}
