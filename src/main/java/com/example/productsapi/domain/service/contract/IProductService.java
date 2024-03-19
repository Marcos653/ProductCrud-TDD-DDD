package com.example.productsapi.domain.service.contract;

import com.example.productsapi.application.dto.response.ProductResponse;

import java.util.List;

public interface IProductService {

    List<ProductResponse> getAll();
}
