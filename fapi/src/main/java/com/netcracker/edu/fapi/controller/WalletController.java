package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Wallet;
import com.netcracker.edu.fapi.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<Wallet> getAllWallet() {
        return walletService.findAll();
    }

    @GetMapping("/wallet/{wallet}")
    @PreAuthorize("hasRole('USER')")
    public Wallet getWalletById(@PathVariable long id) {
        return walletService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Wallet> save(@RequestBody Wallet wallet) {
        if (wallet != null) {
//            Wallet wallet1 =
            return ResponseEntity.ok(walletService.save(wallet));
        }
        return null;
    }
}
