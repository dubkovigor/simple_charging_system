package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Serv;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServRepository extends CrudRepository<Serv, Long> {
    Serv findByServiceName(String serviceName);
    Serv findById(long id);
}
