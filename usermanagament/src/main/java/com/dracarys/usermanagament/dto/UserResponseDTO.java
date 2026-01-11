package com.dracarys.usermanagament.dto;


import com.dracarys.usermanagament.entity.UserDetails;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class UserResponseDTO {

    private String name;
    private String email;
    private String Address;

    public UserResponseDTO(UserDetails userDetails) {
        userDetails.setId(1L);
        userDetails.setEmail("hell");
        userDetails.setName("prudvi");
        this.name = userDetails.getName();
        this.email = userDetails.getEmail();
        System.out.println("Before gettin user address from db");
//        if(userDetails.getUserAddress() != null) {
//            this.Address = userDetails.getUserAddress().getStreet();
//        }
    }

}
