package com.tka.smartbazaar.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tka.smartbazaar.dao.WalletDao;
import com.tka.smartbazaar.entity.Wallet;
import com.tka.smartbazaar.service.WalletService;

@Service
@Transactional
public class WalletServiceImpl implements WalletService {

    private final WalletDao dao;

    public WalletServiceImpl(WalletDao dao) {
        this.dao = dao;
    }

    @Override
    public Wallet create(Wallet w) {
        dao.save(w);
        return w;
    }

    @Override
    public Wallet getById(Long id) {
        return dao.getById(id.intValue());
    }

    @Override
    public Wallet topUp(Long walletId, Double amount) {
        Wallet w = dao.getById(walletId.intValue());
        if (w == null) throw new RuntimeException("Wallet not found with id: " + walletId);

        w.setBalance(w.getBalance() + amount);
        dao.save(w);
        return w;
    }

    @Override
    public Wallet transfer(Long fromWalletId, Long toWalletId, Double amount) {
        Wallet from = dao.getById(fromWalletId.intValue());
        Wallet to = dao.getById(toWalletId.intValue());

        if (from == null || to == null) throw new RuntimeException("Invalid wallet IDs");
        if (from.getBalance() < amount) throw new RuntimeException("Insufficient balance");

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        dao.save(from);
        dao.save(to);

        return from;
    }
}
