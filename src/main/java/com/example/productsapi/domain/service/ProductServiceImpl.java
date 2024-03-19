package com.example.productsapi.domain.service;

import com.example.productsapi.domain.model.Product;
import com.example.productsapi.application.mapper.ProductMapper;
import com.example.productsapi.domain.repository.IProductRepository;
import com.example.productsapi.domain.service.contract.IProductService;
import com.example.productsapi.application.dto.response.ProductResponse;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import jakarta.persistence.EntityNotFoundException;

import static com.example.productsapi.domain.utils.Messages.PRODUCT_NOT_FOUND;

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

    @Override
    public ProductResponse getById(Long id) {
        return mapper.toProductResponse(getProductById(id));
    }

    private Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(PRODUCT_NOT_FOUND + id));
    }
}
