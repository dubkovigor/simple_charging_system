package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByLogin(String login);
    User findById(long id);
    User findByFirstName(String firstName);
    User findBySecondName(String secondName);
    User save(User user);
    void delete(long id);
}
