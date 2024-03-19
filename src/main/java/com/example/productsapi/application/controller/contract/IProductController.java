package com.example.productsapi.application.controller.contract;

import com.example.productsapi.application.dto.request.ProductRequest;
import com.example.productsapi.application.dto.response.ProductResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface IProductController {

    @GetMapping
    List<ProductResponse> getAll();

    @GetMapping("{id}")
    ProductResponse getById(@PathVariable Long id);

    @PostMapping
    ProductResponse save(ProductRequest request);
}
