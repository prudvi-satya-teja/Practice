package com.example.springcache.entity;

import com.example.springcache.entity.ck.TeacherDetailsCK;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "students",
        schema="records",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "phone"),
            @UniqueConstraint(columnNames = {"name", "age"})
        }
)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "studentRegion")
public class Student {

//    @EmbeddedId
//    TeacherDetailsCK teacherDetailsCK;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
//    @SequenceGenerator(sequenceName = "seq_name", allocationSize=3, initialValue = 100, name="generator_name")
    private Long id;

    @Column(name="name", nullable = false, length = 3)
    private String name;

    private String address;

    @Column(name="age", nullable = false)
    private int age;

    @Column(name="phone", unique = true,  nullable = false, length = 10)
    private String phone;

}
