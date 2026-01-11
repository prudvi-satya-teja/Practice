package com.project.simpleWebApp.Controllers;

import com.project.simpleWebApp.Models.Customer;
import com.project.simpleWebApp.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public  class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer/add")
    public String createCustemer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/customer/get-details/{id}")
    public Customer findCustomerById(@PathVariable int id) {
        return customerService.findCustomerById(id);
    }

    @PutMapping("/customer/update")
    public String updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customer/delete/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustoemr(id);
    }

}