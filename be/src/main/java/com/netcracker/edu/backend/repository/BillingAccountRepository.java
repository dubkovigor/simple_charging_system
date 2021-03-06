package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.BillingAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingAccountRepository extends CrudRepository<BillingAccount, Long > {
    BillingAccount findById (long id);
    BillingAccount findByWalletId(long walletId);
}
