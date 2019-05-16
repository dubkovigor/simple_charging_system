package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Role;
import com.netcracker.edu.backend.repository.RoleRepository;
import com.netcracker.edu.backend.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAllRole() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role findById(long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void delete(long id) {
        roleRepository.deleteById(id);
    }
}
