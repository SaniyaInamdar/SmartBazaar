package com.tka.smartbazaar.service;

import com.tka.smartbazaar.entity.Wallet;

public interface WalletService {
	Wallet create(Wallet w);
    Wallet getById(Long id);
    Wallet topUp(Long walletId, Double amount);
    Wallet transfer(Long fromWalletId, Long toWalletId, Double amount);
}
