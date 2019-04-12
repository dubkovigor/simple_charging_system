package com.netcracker.edu.backend.service;

        import com.netcracker.edu.backend.entity.BillingAccount;

        import java.util.List;

public interface BillingAccountService {
    List<BillingAccount> findAll();
    BillingAccount findById(long id);
    BillingAccount findByNumber(Long number);
    BillingAccount findByWalletId(Long id);
    BillingAccount save(BillingAccount billingAccount);
    void delete(Long id);
}
