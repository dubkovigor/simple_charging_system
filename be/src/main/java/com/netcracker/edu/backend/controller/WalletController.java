package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/wallet")
public class WalletController {

    private WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping(value = "")
    public List<Wallet> getAllWallet() {
        return walletService.findAll();
    }
    @GetMapping(value = "/service/{serviceId}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable(name = "serviceId") long walletId) {
        Wallet wallet = walletService.findById(walletId);
        return ResponseEntity.ok(wallet);
    }

    @PostMapping
    public Wallet saveWallet(@RequestBody Wallet wallet) {
        return walletService.save(wallet);
    }

    @DeleteMapping(value = "/delete/{walletId}")
    public ResponseEntity delete(@PathVariable (name = "walletId") long id) {
        walletService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
