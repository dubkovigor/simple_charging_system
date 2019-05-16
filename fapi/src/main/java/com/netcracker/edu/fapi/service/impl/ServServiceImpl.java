package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Serv;
import com.netcracker.edu.fapi.service.ServService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ServServiceImpl implements ServService {
    private ArrayList<Serv> servs = new ArrayList<>();

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Serv> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Serv[] servs = restTemplate.getForObject(backendServerUrl + "/api/service", Serv[].class);
        return servs == null ? Collections.emptyList() : Arrays.asList(servs);
    }

    @Override
    public Serv findById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        Serv serv = restTemplate.getForObject(backendServerUrl + "/api/service/" + id, Serv.class);
        return serv;
    }

    @Override
    public Serv findByServiceName(String serviceName) {
        RestTemplate restTemplate = new RestTemplate();
        Serv serv = restTemplate.getForObject(backendServerUrl + "/api/service/" + serviceName, Serv.class);
        return serv;
    }

    @Override
    public Serv save(Serv serv) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/service", serv, Serv.class).getBody();
    }

    @Override
    public void delete(long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/service/delete/" + id);
    }

    @Override
    public long countUser(long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/service/count/" + id, Long.class);
    }
}
