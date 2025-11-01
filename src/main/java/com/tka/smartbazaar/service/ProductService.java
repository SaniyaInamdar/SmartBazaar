package com.tka.smartbazaar.service;

import java.util.List;

import com.tka.smartbazaar.entity.Product;

public interface ProductService {
    Product create(Product p);
    Product update(Long id, Product p);
    void delete(Long id);
    Product getById(Long id);
    List<Product> listAll();
    List<Product> findByCategory(String category);
}
