package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.BillingAccount;
import com.netcracker.edu.backend.entity.Serv;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.BillingAccountService;
import com.netcracker.edu.backend.service.ServService;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;
    private ServService servService;
    @Autowired
    private BillingAccountService billingAccountService;

    @Autowired
    public UserController(UserService userService, ServService servService) {
        this.userService = userService;
        this.servService = servService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> getUserByLogin(@RequestBody String login) {
        User user = userService.findByLogin(login);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/id")
    public ResponseEntity<User> getUserById(@RequestBody long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/firstname/{firstname}")
    public ResponseEntity<User> getUserByFirstName(@PathVariable(name = "firstname") String firstname) {
        User user = userService.findByFirstName(firstname);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        BillingAccount billingAccount = this.billingAccountService.save(new BillingAccount(false, new Wallet(1000)));
        user.setBa_Id(billingAccount);
        return userService.save(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") long id) {
        User user = userService.findById(id);
        if (user != null) {
            userService.delete(id);
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public User subscribeUser(@RequestParam long service_id, @RequestBody User user) {
//        User user = userService.findById(user_id);
        Serv service = servService.findById(service_id);
        Set<Serv> servs = user.getServs();
        servs.add(service);
        user.setServs(servs);
        userService.save(user);
        return user;
    }

    @RequestMapping(value = "/refuse", method = RequestMethod.POST)
    public User unsunscribeUser(@RequestParam long service_id, @RequestBody User user) {
        Serv service = servService.findById(service_id);
        Set<Serv> servs = user.getServs();
        Set<Serv> newServs = servs;
        newServs.forEach(serv -> {if (serv.getId() == service.getId()){
            servs.remove(serv);
        }});
        user.setServs(servs);
        userService.save(user);
        return user;
    }

    public User writeOffMoney(User user, Serv service){
        user.getBa_Id().getWallet().setAmount(user.getBa_Id().getWallet().getAmount() - service.getPrice());
        return user;
    }

}
