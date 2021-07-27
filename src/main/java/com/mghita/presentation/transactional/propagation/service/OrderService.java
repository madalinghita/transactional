package com.mghita.presentation.transactional.propagation.service;

import com.mghita.presentation.transactional.propagation.model.Order;
import com.mghita.presentation.transactional.propagation.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {

    OrderRepository orderRepository;

    public List<Order> getOrders() {
        return this.orderRepository.findAll();
    }

    public Order addOrder(Order order) {
        return this.orderRepository.save(order);
    }
}
