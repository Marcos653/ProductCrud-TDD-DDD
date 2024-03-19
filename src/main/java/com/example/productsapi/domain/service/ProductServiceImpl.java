package com.example.productsapi.domain.service;

import com.example.productsapi.application.mapper.ProductMapper;
import com.example.productsapi.domain.repository.IProductRepository;
import com.example.productsapi.domain.service.contract.IProductService;
import com.example.productsapi.application.dto.response.ProductResponse;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public List<ProductResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .toList();
    }
}
