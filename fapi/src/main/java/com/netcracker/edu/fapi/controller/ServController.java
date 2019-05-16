package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Serv;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.service.ServService;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/service")
public class ServController {
    @Autowired
    private ServService servService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Serv> save(@RequestBody Serv serv) {
        if (serv != null) {
            return ResponseEntity.ok(servService.save(serv));
        }
        return null;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        this.servService.delete(id);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Serv> getAllService() {
        return servService.findAll();
    }

    @GetMapping(value = "/count/{id}")
    public long countUser(@PathVariable(name = "id") long id){
        return servService.countUser(id);
    }
}
