package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/login")
    public User getUserByLogin(@RequestBody String login) {
        return userService.findByLogin(login);
    }

    @GetMapping("/firstname/{firstname}")
    public User getUserByFirstName(@PathVariable String firstname) {
        return userService.findByFirstName(firstname);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        if (user != null) {
            return ResponseEntity.ok(userService.save(user));
        }
        return null;
    }

    @PostMapping(value = "/join")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<User> subscribeUser(@RequestParam long service_id, @RequestBody User user){
        return ResponseEntity.ok(userService.setServ(user, service_id));
    }

    @PostMapping(value = "/refuse")
    public ResponseEntity<User> unsubscribeUser(@RequestParam long service_id, @RequestBody User user) {
        return ResponseEntity.ok(userService.deleteServ(user, service_id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable(name = "id") long id) {
        this.userService.delete(id);
    }
}
