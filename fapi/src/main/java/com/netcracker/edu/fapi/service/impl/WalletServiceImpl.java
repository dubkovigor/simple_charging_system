package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Wallet;
import com.netcracker.edu.fapi.service.WalletService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {
    private ArrayList<Wallet> wallets = new ArrayList<>();

    @Value("${backend.server.url}")
    private String backendServerUrl;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Wallet> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Wallet[] wallets = restTemplate.getForObject(backendServerUrl + "/api/wallet", Wallet[].class);
        return wallets == null ? Collections.emptyList() : Arrays.asList(wallets);
    }

    @Override
    public Wallet findById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        Wallet wallet = restTemplate.getForObject(backendServerUrl + "/api/wallet" + id, Wallet.class);
        return wallet;
    }

    @Override
    public Wallet save(Wallet wallet) {
        return restTemplate.postForObject(backendServerUrl + "/api/wallet", wallet, Wallet.class);
    }
}
