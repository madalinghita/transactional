package com.mghita.presentation.transactional.propagation.repository;

import com.mghita.presentation.transactional.propagation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
