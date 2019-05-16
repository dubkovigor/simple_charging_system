//package com.netcracker.edu.fapi.service.impl;
//
//import com.netcracker.edu.fapi.models.Customer;
//import com.netcracker.edu.fapi.service.CustomerService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class CustomerServiceImpl implements CustomerService{
//    private ArrayList<Customer> customers = new ArrayList<>();
//
//    @Value("${backend.server.url}")
//    private String backendServerUrl;
//
//    @Override
//    public Customer findByFirstName(String firstName) {
//        RestTemplate restTemplate = new RestTemplate();
//        Customer customer = restTemplate.getForObject(backendServerUrl + "/api/customer/firstName" + firstName, Customer.class);
//        return customer;
//    }
//
//    @Override
//    public Customer findBySecondName(String secondName) {
//        RestTemplate restTemplate = new RestTemplate();
//        Customer customer = restTemplate.getForObject(backendServerUrl + "/api/customer/secondName/" + secondName, Customer.class);
//        return customer;
//    }
//
//    @Override
//    public List<Customer> findAll() {
//        RestTemplate restTemplate = new RestTemplate();
//        Customer[] customersResponse = restTemplate.getForObject(backendServerUrl + "/api/customer", Customer[].class);
//        return customersResponse == null ? Collections.emptyList() : Arrays.asList(customersResponse);
//    }
//    @Override
//    public Customer save(Customer customer) {
////        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
////        RestTemplate restTemplate = new RestTemplate();
////        return restTemplate.postForEntity(backendServerUrl + "/api/user", user, User.class).getBody();
////        users.add(user);
////        return user;
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.postForEntity(backendServerUrl + "/api/customer", customer, Customer.class).getBody();
//    }
//}
