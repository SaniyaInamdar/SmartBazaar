package com.tka.smartbazaar.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.smartbazaar.entity.Wallet;

@Repository
public class WalletDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Wallet w) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(w);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public Wallet getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Wallet.class, id);
        }
    }
}
