package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.BillingAccount;
import com.netcracker.edu.fapi.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/ba")
public class BillingAccountController {
    @Autowired
    private BillingAccountService billingAccountService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<BillingAccount> getAllBillingAccount() {
        return billingAccountService.findAll();
    }



}
