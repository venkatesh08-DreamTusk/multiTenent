package com.multiTenent.multiTenent.service;

import com.multiTenent.multiTenent.enity.Customer;
import com.multiTenent.multiTenent.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
