package com.mghita.presentation.transactional.propagation.service;

import com.mghita.presentation.transactional.propagation.repository.ProductRepository;
import com.mghita.presentation.transactional.propagation.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    ProductRepository productRepository;

    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return this.productRepository.save(product);
    }
}
