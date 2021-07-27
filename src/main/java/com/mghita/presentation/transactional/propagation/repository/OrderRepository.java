package com.mghita.presentation.transactional.propagation.repository;

import com.mghita.presentation.transactional.propagation.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
