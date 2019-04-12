package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Role;
import com.netcracker.edu.fapi.service.RoleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private ArrayList<Role> roles = new ArrayList<>();

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Role> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Role[] usersResponse = restTemplate.getForObject(backendServerUrl + "/api/role", Role[].class);
        return usersResponse == null ? Collections.emptyList() : Arrays.asList(usersResponse);
    }

    @Override
    public Role findByRoleName(String roleName) {
        RestTemplate restTemplate = new RestTemplate();
        Role role = restTemplate.getForObject(backendServerUrl + "/api/role/" + roleName, Role.class);
        return role;
    }

    @Override
    public Role findById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        Role role = restTemplate.getForObject(backendServerUrl + "/api/role/" + id, Role.class);
        return role;
    }

    @Override
    public Role save(Role role) {
        return null;
    }
}
