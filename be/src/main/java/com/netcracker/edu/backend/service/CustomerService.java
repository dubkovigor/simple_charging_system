package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findByFirstName(String firstName);
    Customer save(Customer customer);
    void delete(Long id);

}
