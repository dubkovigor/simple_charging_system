package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Role;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.repository.RoleRepository;
import com.netcracker.edu.backend.repository.UserRepository;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }


    @Override
    public User findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public User findBySecondName(String secondName) {
        return userRepository.findBySecondName(secondName);
    }

    @Override
    public User save(User user) {
//        Role roles
//        role.add(roleRepository.findById(1));
        user.setRole(roleRepository.findById(2));
        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
