package com.tka.smartbazaar.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tka.smartbazaar.dao.OrderDao;
import com.tka.smartbazaar.entity.Order;
import com.tka.smartbazaar.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderDao dao;

    public OrderServiceImpl(OrderDao dao) {
        this.dao = dao;
    }

    @Override
    public Order create(Order order) {
        dao.save(order);
        return order;
    }

    @Override
    public Order getById(Long id) {
        return dao.getById(id.intValue());
    }

    @Override
    public List<Order> listAll() {
        return List.of(); 
    }
}
