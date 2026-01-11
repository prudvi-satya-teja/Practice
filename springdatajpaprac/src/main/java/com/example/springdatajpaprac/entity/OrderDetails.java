package com.example.springdatajpaprac.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_details")
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class OrderDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;

    @Column(name="product_name", nullable = false)
    private String productName;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id_fk", referencedColumnName = "user_id")
    UserDetails userDetails;

}
