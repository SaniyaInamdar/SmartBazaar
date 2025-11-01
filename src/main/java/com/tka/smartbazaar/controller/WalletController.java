package com.tka.smartbazaar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tka.smartbazaar.entity.Wallet;
import com.tka.smartbazaar.service.WalletService;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService service;

    public WalletController(WalletService service) { this.service = service; }

    @PostMapping
    public Wallet create(@RequestBody Wallet w) {
        return service.create(w);
    }

    @GetMapping("/{id}")
    public Wallet get(@PathVariable Long id) { return service.getById(id); }

    @PostMapping("/{id}/topup")
    public Wallet topUp(@PathVariable Long id, @RequestParam Double amount) { return service.topUp(id, amount); }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam Long from, @RequestParam Long to, @RequestParam Double amount) {
        service.transfer(from, to, amount);
        return ResponseEntity.ok("Transfer successful");
    }
}
