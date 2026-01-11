package com.example.datajpapractice.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Long employeeId;

    @Column(name="employee_name")
    private String employeeName;

    @Column(name="salary")
    private Double salary;

    @Column(name="join_date")
    private Date joinDate;

    @Column(name="email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Department department;

}
