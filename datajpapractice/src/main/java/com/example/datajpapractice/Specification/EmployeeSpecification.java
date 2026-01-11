package com.example.datajpapractice.Specification;

import com.example.datajpapractice.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

   public static Specification<Employee> hasName(String name) {
        return (Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) ->  {
            return criteriaBuilder.like(root.get("employeeName"), "%" + name + "%");
        };
    }

    public static  Specification<Employee> hasDepartmentId(Long id)   {
        return(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder ) -> {
            return criteriaBuilder.equal(root.get("department").get("departmentId"), id);
        };
    }

    public static  Specification<Employee> hasSalaryGreaterThan(Double minSalary)   {
        return(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            return criteriaBuilder.greaterThan(root.get("salary"), minSalary);
        };
    }

    public static  Specification<Employee> hasSalaryLessThan(Double maxSalary)   {
        return(Root<Employee> root,CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            return criteriaBuilder.lessThan(root.get("salary"), maxSalary);
        };
    }

    public static  Specification<Employee> hasEmail(String email) {
        return (Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("email"), email);
        };
    }

}
