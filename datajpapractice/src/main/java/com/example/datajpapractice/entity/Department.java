package com.example.datajpapractice.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="department_id")
    private Long departmentId;

    @NotBlank(message = "departmentName is required")
    @Column(name="department_name")
    private String departmentName;

    @Column(name="department_email")
    @Email(message = "Email should be in a valid format")
    private String departmentEmail;


}
