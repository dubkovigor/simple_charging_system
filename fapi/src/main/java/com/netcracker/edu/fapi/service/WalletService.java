package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Wallet;

import java.util.List;

public interface WalletService {
    List<Wallet> findAll();
    Wallet findById(long id);
    Wallet save(Wallet wallet);
//    void delete(long id);
}
