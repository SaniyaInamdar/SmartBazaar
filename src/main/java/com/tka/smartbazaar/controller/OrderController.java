package com.tka.smartbazaar.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.tka.smartbazaar.entity.Order;
import com.tka.smartbazaar.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return service.create(order);
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Order> list() {
        return service.listAll();
    }
}
