package com.example.derivedqueries.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="address_table")
public class AddressDetails {
    @Id
    @Column(name="address_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String village;
    private String city;
    private String state;


}
