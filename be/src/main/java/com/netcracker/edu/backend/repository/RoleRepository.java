package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>, JpaRepository<Role, Long> {
    Role findById(long id);
    Role findByRoleName(String roleName);
}
