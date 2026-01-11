package com.example.datajpapractice.service;
import com.example.datajpapractice.Specification.EmployeeSpecification;
import com.example.datajpapractice.entity.Department;
import com.example.datajpapractice.entity.Employee;
import com.example.datajpapractice.repository.DepartmentRepository;
import com.example.datajpapractice.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> saveAll(List<Employee> employees) {
        List<Employee> createdEmployees = new ArrayList<>();

        employees.stream()
                .filter(employee -> employee.getDepartment() != null)
                .forEach(employee -> {
                    Department department = departmentRepository.findById(employee.getDepartment().getDepartmentId()).get();
                    employee.setDepartment(department);
                    employeeRepository.save(employee);
                    createdEmployees.add(employee);
                });

        return createdEmployees;
    }

    public List<Employee> findEmployee(String name, Double minSalary, Double maxSalary, String email, Long departmentId, Pageable pageable) {
        Specification<Employee> specification = Specification.where(null);

        if(name != null) specification = specification.and(EmployeeSpecification.hasName(name));
        if(email != null)  specification = specification.and(EmployeeSpecification.hasEmail(email));
        if(departmentId != null)   specification = specification.and(EmployeeSpecification.hasDepartmentId(departmentId));
        if(maxSalary != null)  specification =  specification.and(EmployeeSpecification.hasSalaryLessThan(maxSalary));
        if(minSalary != null)   specification =  specification.and(EmployeeSpecification.hasSalaryGreaterThan(minSalary));

        return  employeeRepository.findAll(specification);
    }


    public List<Employee> searchEmployee(String name, Double minSalary, Double maxSalary, String email,Long departmentId, Pageable pageable) {
         CriteriaBuilder cb = entityManager.getCriteriaBuilder();

         CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

         Root<Employee> root = cq.from(Employee.class);

         Join<Employee, Department> join = root.join("department", JoinType.INNER);

         cq.select(root);

         List<Predicate> predicates = new ArrayList<>();

         if(name != null) predicates.add(cb.like(root.get("name"), "%" + name + "%"));
         if(email != null) predicates.add(cb.like(root.get("email"), "%" + email + "%"));
         if(minSalary != null) predicates.add(cb.greaterThanOrEqualTo(root.get("salary"), minSalary));
         if(maxSalary != null) predicates.add(cb.lessThanOrEqualTo(root.get("salary"), maxSalary));
         if(departmentId != null) predicates.add(cb.equal(root.get("department").get("departmentId"), departmentId));

         cq.where(predicates.toArray(new Predicate[0]));

         TypedQuery<Employee> query = entityManager.createQuery(cq);

         query.setFirstResult(pageable.getPageSize());
         query.setMaxResults(pageable.getPageSize());

        return query.getResultList();
    }


}
