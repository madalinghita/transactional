package com.mghita.presentation.transactional.propagation.controller;

import com.mghita.presentation.transactional.propagation.model.Order;
import com.mghita.presentation.transactional.propagation.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping(path = "/orders")
@RestController
public class OrderController {

    OrderService orderService;

    @GetMapping
    public List<Order> getOrders() {
        return this.orderService.getOrders();
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return this.orderService.addOrder(order);
    }
}
