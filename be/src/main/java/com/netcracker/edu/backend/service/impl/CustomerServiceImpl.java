//package com.netcracker.edu.backend.service.impl;
//
//import com.netcracker.edu.backend.Debiter;
//import com.netcracker.edu.backend.entity.Customer;
//import com.netcracker.edu.backend.entity.Serv;
//import com.netcracker.edu.backend.repository.CustomerRepository;
//import com.netcracker.edu.backend.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Set;
//
//@Service
//public class CustomerServiceImpl implements CustomerService{
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    public CustomerServiceImpl(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
//
//    @Override
//    public List<Customer> findAll() {
//        return (List<Customer>) customerRepository.findAll();
//    }
//
//    @Override
//    public Customer findByFirstName(String firstName) {
//        return customerRepository.findByFirstName(firstName);
//    }
//
//    @Override
//    public Customer findById(long id) {
//        return customerRepository.findById(id);
//    }
//
//
//    @Override
//    public Customer save(Customer customer) {
//        return customerRepository.save(customer);
//    }
//
//    @Override
//    public void delete(long id) {
//        customerRepository.deleteById(id);
//    }
//}
