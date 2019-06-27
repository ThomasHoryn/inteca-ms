package com.tomhor.customer.customerservice.controllers;

import com.tomhor.customer.customerservice.model.Customer;
import com.tomhor.customer.customerservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/credit/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get-all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/new")
    public Customer saveCustomer(@RequestBody Customer customerToSave){
        return customerService.saveCustomer(customerToSave);
    }
}
