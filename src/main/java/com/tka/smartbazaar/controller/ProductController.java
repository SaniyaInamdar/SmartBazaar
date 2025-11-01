package com.tka.smartbazaar.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.tka.smartbazaar.entity.Product;
import com.tka.smartbazaar.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) { this.service = service; }

    @GetMapping
    public List<Product> list() { return service.listAll(); }

    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Product create(@RequestBody Product p) { return service.create(p); }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product p) { return service.update(id, p); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @GetMapping("/category/{cat}")
    public List<Product> byCategory(@PathVariable String cat) { return service.findByCategory(cat); }
}
