package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.BillingAccount;
import com.netcracker.edu.fapi.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BillingAccountServiceImpl implements BillingAccountService {
    private ArrayList<BillingAccount> customers = new ArrayList<>();

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<BillingAccount> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        BillingAccount[] billingAccounts = restTemplate.getForObject(backendServerUrl + "/api/ba", BillingAccount[].class);
        return billingAccounts == null ? Collections.emptyList() : Arrays.asList(billingAccounts);
    }

    @Override
    public BillingAccount findById(long id) {
        RestTemplate restTemplate = new RestTemplate();
        BillingAccount billingAccount = restTemplate.getForObject(backendServerUrl + "/api/ba/" + id, BillingAccount.class);
        return billingAccount;
    }

    @Override
    public BillingAccount findByWalletId(long id) {
        return null;
    }

    @Override
    public BillingAccount save(BillingAccount billingAccount) {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/ba", billingAccount, BillingAccount.class).getBody();
    }


}
