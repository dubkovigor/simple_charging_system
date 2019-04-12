package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.BillingAccount;
import com.netcracker.edu.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ba")
public class BillingAccountController {
    private BillingAccountService billingAccountService;

    @Autowired
    public BillingAccountController(BillingAccountService billingAccountService) {
        this.billingAccountService = billingAccountService;
    }

    @GetMapping(value = "")
    public List<BillingAccount> getAllBillingAccount() {
        return billingAccountService.findAll();
    }

    @GetMapping(value = "id/{id}")
    public BillingAccount findBillingAccountById(@PathVariable(name = "id") Long id) {
        return billingAccountService.findById(id);
    }

    @GetMapping(value = "number/{number}")
    public BillingAccount findBillingAccountByNumber(@PathVariable(name = "number") Long number) {
        return billingAccountService.findByNumber(number);
    }

    @GetMapping(value = "walletId/{walletId}")
    public BillingAccount findBillingAccountByWallet(@PathVariable(name = "walletId") Long walletId) {
        return billingAccountService.findByWalletId(walletId);
    }

    @PostMapping
    public BillingAccount saveBillingAccount(@RequestBody BillingAccount billingAccount) {
        return billingAccountService.save(billingAccount);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete(@PathVariable (name = "id") Long id) {
        billingAccountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


