package com.tomhor.customer.customerservice.services;

import com.tomhor.customer.customerservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomers();

}
