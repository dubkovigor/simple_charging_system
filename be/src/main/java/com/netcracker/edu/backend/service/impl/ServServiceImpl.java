package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Serv;
import com.netcracker.edu.backend.repository.ServRepository;
import com.netcracker.edu.backend.service.ServService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServServiceImpl implements ServService {
    private ServRepository servRepository;

    public ServServiceImpl(ServRepository servRepository) {
        this.servRepository = servRepository;
    }

    @Override
    public List<Serv> findAll() {
        return (List<Serv>) servRepository.findAll();
    }

    @Override
    public Serv findById(long id) {
        return servRepository.findById(id);
    }

    @Override
    public Serv findByServiceName(String serviceName) {
        return servRepository.findByServiceName(serviceName);
    }

    @Override
    public Serv save(Serv serv) {
        return servRepository.save(serv);
    }

    @Override
    public void delete(Long id) {
        servRepository.deleteById(id);
    }
}
