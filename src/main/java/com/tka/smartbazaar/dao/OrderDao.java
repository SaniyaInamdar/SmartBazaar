package com.tka.smartbazaar.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.smartbazaar.entity.Order;

@Repository
public class OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Order o) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(o);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public Order getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Order.class, id);
        }
    }

    public List<Order> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Order", Order.class).list();
        }
    }
}
