package com.tka.smartbazaar.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.smartbazaar.entity.Product;

@Repository
public class ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Product p) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(p);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public Product getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Product.class, id);
        }
    }

    public List<Product> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Product", Product.class).list();
        }
    }

    public void delete(int id) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            Product p = session.get(Product.class, id);
            if (p != null) session.delete(p);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<Product> findByCategory(String category) {
        try (Session session = sessionFactory.openSession()) {
            Query<Product> q = session.createQuery("from Product where lower(category) = :c", Product.class);
            q.setParameter("c", category.toLowerCase());
            return q.list();
        }
    }
}
