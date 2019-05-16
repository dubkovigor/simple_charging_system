package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.BillingAccount;
import com.netcracker.edu.backend.repository.BillingAccountRepository;
import com.netcracker.edu.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingAccountServiceImpl implements BillingAccountService {

    private BillingAccountRepository billingAccountRepository;

    @Autowired
    public BillingAccountServiceImpl(BillingAccountRepository billingAccountRepository) {
        this.billingAccountRepository = billingAccountRepository;
    }

    @Override
    public List<BillingAccount> findAll() {
        return (List<BillingAccount>) billingAccountRepository.findAll();
    }

    @Override
    public BillingAccount findById(long id) {
        return billingAccountRepository.findById(id);
    }

    @Override
    public BillingAccount findByWalletId(long walletId) {
        return billingAccountRepository.findByWalletId(walletId);
    }

    @Override
    public BillingAccount save(BillingAccount billingAccount) {
        return billingAccountRepository.save(billingAccount);
    }

    @Override
    public void delete(Long id) {
        billingAccountRepository.deleteById(id);
    }
}
