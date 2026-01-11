package com.example.springcache.entity.ck;


import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

//@Embeddable
public class TeacherDetailsCK implements Serializable {

    private String name;
    private String address;

    public TeacherDetailsCK(){
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof TeacherDetailsCK teacherDetailsCK)) return false;
        return teacherDetailsCK.name.equals(name) && teacherDetailsCK.address.equals(address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
