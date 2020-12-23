package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Serv;

import java.util.List;

public interface ServService {
    List<Serv> findAll();
    Serv findById(long id);
    Serv findByServiceName(String serviceName);
    List<Serv> findByCategory(String category);
    Serv save(Serv serv);
    void delete(Long id);
}
