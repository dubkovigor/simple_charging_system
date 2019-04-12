package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.repository.WalletRepository;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {
    private WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public List<Wallet> findAll() {
        return (List<Wallet>) walletRepository.findAll();
    }

    @Override
    public Wallet findById(long id) {
        return walletRepository.findById(id);
    }

    @Override
    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public void delete(Long id) {
        walletRepository.deleteById(id);
    }
}
