package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Role;
import com.netcracker.edu.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/role")
public class RoleController {
    private RoleService roleService;

    public RoleController() {}

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "")
    public List<Role> getAllCustomers() {
        return roleService.findAllRole();
    }

    @GetMapping(value = "firstName/{id}")
    public Role findById(@PathVariable(name = "id") long id) {
        return roleService.findById(id);
    }

    @GetMapping(value = "roleName/{roleName}")
    public Role findByRoleName(@PathVariable(name = "roleName") String roleName) {
        return roleService.findByRoleName(roleName);
    }

    @PostMapping
    public Role saveRole(@RequestBody Role role) {
        return roleService.save(role);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable (name = "id") long id) {
        roleService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
