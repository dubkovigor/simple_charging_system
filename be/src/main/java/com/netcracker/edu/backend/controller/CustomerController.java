package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "firstName/{firstName}")
    public Customer findByFistName(@PathVariable (name = "firstName") String firstName) {
        return customerService.findByFirstName(firstName);
    }

    @GetMapping(value = "")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer saveUser(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable (name = "id") Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

