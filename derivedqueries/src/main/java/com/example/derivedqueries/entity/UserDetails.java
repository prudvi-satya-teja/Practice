package com.example.derivedqueries.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
@NamedEntityGraph(
        name="userAddressList",
        attributeNodes= {
                @NamedAttributeNode("addressDetails")
        }
)
@NamedQuery(
        name="find",
        query = "select u from UserDetails  u where u.name = :name"
)
public class UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    @BatchSize(size=4)
    private List<AddressDetails> addressDetails;
}
