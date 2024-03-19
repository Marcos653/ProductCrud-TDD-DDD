package com.example.productsapi.domain.repository;

import com.example.productsapi.domain.model.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> findAll();
}
