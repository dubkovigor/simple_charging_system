package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findByRoleName(String roleName);
    Role findById(long id);
    Role save(Role role);
}
