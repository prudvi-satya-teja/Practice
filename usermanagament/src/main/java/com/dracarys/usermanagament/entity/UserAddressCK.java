package com.dracarys.usermanagament.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class UserAddressCK {

    private String street;
    private String village;

    public UserAddressCK(){}

    @Override
    public int hashCode() {
        return Objects.hash(this.street, this.village);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof UserAddressCK other)) return false;
        return other.getStreet().equals(this.street) && other.getVillage().equals(this.village);
    }
}
