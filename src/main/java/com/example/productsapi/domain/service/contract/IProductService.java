package com.example.productsapi.domain.service.contract;

import com.example.productsapi.application.dto.request.ProductRequest;
import com.example.productsapi.application.dto.response.ProductResponse;

import java.util.List;

public interface IProductService {

    List<ProductResponse> getAll();

    ProductResponse getById(Long id);

    ProductResponse save(ProductRequest request);
}
