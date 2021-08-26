package com.mghita.presentation.transactional.propagation.repository;

import com.mghita.presentation.transactional.propagation.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
