package com.example.productsapi.application.controller;

import com.example.productsapi.application.dto.request.ProductRequest;
import com.example.productsapi.domain.service.contract.IProductService;
import com.example.productsapi.application.dto.response.ProductResponse;
import com.example.productsapi.application.controller.contract.IProductController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController implements IProductController {

    private final IProductService service;

    @Override
    public List<ProductResponse> getAll() {
        return service.getAll();
    }

    @Override
    public ProductResponse getById(Long id) {
        return service.getById(id);
    }

    @Override
    public ProductResponse save(ProductRequest request) {
        return service.save(request);
    }
}
