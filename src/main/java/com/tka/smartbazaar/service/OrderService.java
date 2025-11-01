package com.tka.smartbazaar.service;

import java.util.List;
import com.tka.smartbazaar.entity.Order;

public interface OrderService {
    Order create(Order order);
    Order getById(Long id);
    List<Order> listAll();
}
