//package com.netcracker.edu.fapi.controller;
//
//import com.netcracker.edu.fapi.models.Customer;
//import com.netcracker.edu.fapi.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/api/customer")
//public class CustomerController {
//
//    @Autowired
//    private CustomerService customerService;
//
//    @GetMapping
//    public List<Customer> getAllUCustomers() {
//        return customerService.findAll();
//    }
//
//    @GetMapping("/firstName/{firstName}")
//    public Customer getCustomerByFirstName(@PathVariable String firstName) {
//        return customerService.findByFirstName(firstName);
//    }
//
//    //    @GetMapping(value = "")
////    public User saveUser(@RequestBody User user) {
////        return userService.save(user);
////    }
//    @PostMapping()
//    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
//        if (customer != null) {
//            return ResponseEntity.ok(customerService.save(customer));
//        }
//        return ResponseEntity.badRequest().build();
//    }
//}
