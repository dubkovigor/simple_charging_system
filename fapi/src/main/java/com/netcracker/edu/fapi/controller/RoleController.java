package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Role;
import com.netcracker.edu.fapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllUsers() {
        return roleService.findAll();
    }

    @GetMapping("/login/{login}")
    public Role getRoleById(@PathVariable long id) {
        return roleService.findById(id);
    }

    @PostMapping(value ="")
    public ResponseEntity<Role> save(@RequestBody Role role) {
        if (role != null) {
            return ResponseEntity.ok(roleService.save(role));
        }
        return null;
    }
}
