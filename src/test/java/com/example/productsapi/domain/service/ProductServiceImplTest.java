package com.example.productsapi.domain.service;

import com.example.productsapi.application.dto.response.ProductResponse;
import com.example.productsapi.application.mapper.ProductMapper;
import com.example.productsapi.domain.repository.IProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private IProductRepository repository;
    @Mock
    private ProductMapper mapper;

    @Test
    void getAll_ShouldReturnListProducts_whenCalled() {
        when(repository.findAll())
                .thenReturn(List.of());

        var result = productService.getAll();

        assertThat(result)
                .isInstanceOf(List.class);

        verify(repository).findAll();
    }
}
