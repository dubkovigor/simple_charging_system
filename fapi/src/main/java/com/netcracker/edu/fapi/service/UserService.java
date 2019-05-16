package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.User;
import java.util.List;

public interface UserService {

    User findByLogin(String login);
    User findById(long id);
    List<User> findAll();
    User findByFirstName(String login);
    User findBySecondName(String login);
    User setServ(User user, long serv_id);
    User deleteServ(User user, long serv_id);
    User save(User user);
    void delete(long id);
}
