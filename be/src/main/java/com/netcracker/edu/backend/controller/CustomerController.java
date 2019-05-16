//package com.netcracker.edu.backend.controller;
//
//import com.netcracker.edu.backend.Debiter;
//import com.netcracker.edu.backend.entity.Customer;
//import com.netcracker.edu.backend.entity.Serv;
//import com.netcracker.edu.backend.service.CustomerService;
//import com.netcracker.edu.backend.service.ServService;
//import com.netcracker.edu.backend.service.impl.CustomerServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Set;
//
//@RestController
//@RequestMapping(value = "/api/customer")
//public class CustomerController{
//    private CustomerService customerService;
//    private ServService servService;
//
//    @Autowired
//    public CustomerController(CustomerService customerService, ServService servService) {
//        this.customerService = customerService;
//        this.servService = servService;
//    }
//
//    @GetMapping(value = "firstName/{firstName}")
//    public Customer findByFistName(@PathVariable (name = "firstName") String firstName) {
//        return customerService.findByFirstName(firstName);
//    }
//
//    @GetMapping(value = "")
//    public List<Customer> getAllCustomers() {
//        return customerService.findAll();
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public Customer saveUser(@RequestBody Customer customer) {
//        return customerService.save(customer);
//    }
//
//    @DeleteMapping(value = "/delete/{id}")
//    public ResponseEntity delete(@PathVariable (name = "id") long id) {
//        customerService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @RequestMapping(value = "/join", method = RequestMethod.POST)
//    public Customer subscribeUser(@RequestParam long service_id, @RequestParam long customer_id){
//        Customer customer = customerService.findById(customer_id);
//        Serv service = servService.findById(service_id);
//        Set<Serv> servs = customer.getServs();
//        servs.add(service);
//        customer.setServs(servs);
//        customerService.save(customer);
//        return customer;
//    }
//}
//
