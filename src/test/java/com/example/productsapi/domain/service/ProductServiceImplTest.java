package com.example.productsapi.domain.service;

import com.example.productsapi.application.mapper.ProductMapper;
import com.example.productsapi.domain.model.Product;
import com.example.productsapi.domain.repository.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static com.example.productsapi.helper.ProductHelper.oneListOfProducts;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private IProductRepository repository;
    @Mock
    private ProductMapper mapper;

    private List<Product> products;

    @BeforeEach
    void setUp() {
        products = oneListOfProducts();
    }

    @Test
    void getAll_shouldReturnListProducts_whenCalled() {
        when(repository.findAll())
                .thenReturn(products);

        var result = productService.getAll();

        assertThat(result)
                .isInstanceOf(List.class)
                .isNotEmpty()
                .hasSize(products.size());

        verify(repository).findAll();
        verify(mapper, times(products.size()))
                .toProductResponse(any(Product.class));
    }

    @Test
    void getAll_shouldReturnEmptyListProducts_whenThereIsNoProduct() {
        when(repository.findAll())
                .thenReturn(Collections.emptyList());

        var result = productService.getAll();

        assertThat(result)
                .isInstanceOf(List.class)
                .isEmpty();

        verify(repository).findAll();
        verifyNoInteractions(mapper);
    }

    @Test
    void getById_shouldReturnProductResponse_whenCalled() {
        fail("Not implemented");
    }
}
