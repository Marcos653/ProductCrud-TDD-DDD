package com.example.productsapi.application.controller.contract;

import com.example.productsapi.application.dto.request.ProductRequest;
import com.example.productsapi.application.dto.response.ProductResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IProductController {

    @GetMapping
    List<ProductResponse> getAll();

    @GetMapping("{id}")
    ProductResponse getById(@PathVariable Long id);

    @PostMapping
    ProductResponse save(@RequestBody ProductRequest request);

    @PutMapping("{id}")
    ProductResponse update(@PathVariable Long id, @RequestBody ProductRequest request);

    @DeleteMapping("{id}")
    void delete(@PathVariable Long id);
}
