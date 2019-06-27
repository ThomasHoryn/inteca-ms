package com.tomhor.customer.customerservice.services;

import com.tomhor.customer.customerservice.model.Customer;
import com.tomhor.customer.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {

        ArrayList<Customer> allCustomers = new ArrayList<>();

        customerRepository.findAll().iterator().forEachRemaining(allCustomers::add);

        return allCustomers;
    }
}
