package com.mghita.presentation.transactional.propagation.controller;

import com.mghita.presentation.transactional.propagation.service.ProductService;
import com.mghita.presentation.transactional.propagation.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping(path = "/products")
@RestController
public class ProductController {

    ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return this.productService.getProducts();
    }
}
