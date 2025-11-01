package com.tka.smartbazaar.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tka.smartbazaar.dao.ProductDao;
import com.tka.smartbazaar.entity.Product;
import com.tka.smartbazaar.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductDao dao;

    public ProductServiceImpl(ProductDao dao) {
        this.dao = dao;
    }

    @Override
    public Product create(Product p) {
        dao.save(p);
        return p;
    }

    @Override
    public Product update(Long id, Product p) {
        Product existing = dao.getById(id.intValue());
        if (existing == null) throw new RuntimeException("Product not found with id: " + id);

        existing.setName(p.getName());
        existing.setCategory(p.getCategory());
        existing.setPrice(p.getPrice());

        dao.save(existing);
        return existing;
    }

    @Override
    public void delete(Long id) {
        dao.delete(id.intValue());
    }

    @Override
    public Product getById(Long id) {
        return dao.getById(id.intValue());
    }

    @Override
    public List<Product> listAll() {
        return dao.getAll();
    }

    @Override
    public List<Product> findByCategory(String category) {
        return dao.findByCategory(category);
    }
}
