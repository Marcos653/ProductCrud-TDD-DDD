package com.example.productsapi.domain.repository;

import com.example.productsapi.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);
}
