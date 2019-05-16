package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRole();
    Role findById(long id);
    Role findByRoleName(String roleName);
    Role save(Role role);
    void delete(long id);
}
