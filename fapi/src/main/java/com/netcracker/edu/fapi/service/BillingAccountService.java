package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.BillingAccount;

import java.util.List;

public interface BillingAccountService {
    List<BillingAccount> findAll();
    BillingAccount findById(long id);
    BillingAccount findByWalletId(long id);
    BillingAccount save(BillingAccount billingAccount);
//    void delete(Long id);
}
