package com.example.productsapi.infra.repository;

import com.example.productsapi.domain.model.Product;
import com.example.productsapi.domain.repository.IProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long>, IProductRepository {

}
