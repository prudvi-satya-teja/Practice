package com.dracarys.usermanagament.entity;

import com.dracarys.usermanagament.dto.UserResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_details")
//@JsonIdentityInfo(
//        generator =  ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn()
//    private UserAddress userAddress;

    @OneToMany(cascade = CascadeType.ALL)
    List<Order> orders;

    public UserResponseDTO toDTO() {
        return new UserResponseDTO(this);
    }

}

