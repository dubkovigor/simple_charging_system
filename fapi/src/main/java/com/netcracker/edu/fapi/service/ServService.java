package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Serv;

import java.util.List;

public interface ServService {
    List<Serv> findAll();
    Serv findById(long id);
    Serv findByServiceName(String serviceName);
    Serv save(Serv serv);
    void delete(long id);
    long countUser(long id);
}
