package com.example.nativequery.entity;


import com.example.nativequery.dto.UserDetailsDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_details")
@NamedNativeQuery(
        name="userDetailsVal",
        query = "Select u.user_name, u.user_email from user_details u where u.user_name = :userName",
        resultSetMapping = "userDetailsMapping"
)
@SqlResultSetMapping(
        name="userDetailsMapping",
        classes = {
                @ConstructorResult(
                        targetClass = UserDetailsDTO.class,
                        columns = {
                                @ColumnResult(name="user_name", type=String.class),
                                @ColumnResult(name="user_email", type=String.class),
                        }
                )
        }
)
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name="user_name")
    private String name;

    @Column(name="user_email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private UserAddress userAddress;
}
