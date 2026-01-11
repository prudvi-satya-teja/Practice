package com.project.simpleWebApp.Services;


import com.project.simpleWebApp.Models.Customer;
import com.project.simpleWebApp.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService  {

    @Autowired
    CustomerRepo customerRepo;

    public String createCustomer(Customer customer) {
        return customerRepo.save(customer).toString();
    }

    public Customer findCustomerById(Integer id) {
        return customerRepo.findById(id).orElse(null);
    }

    public String updateCustomer(Customer customer) {
        return customerRepo.save(customer).toString();
    }

    public void deleteCustoemr(int id) {
        customerRepo.deleteById(id);
    }
}