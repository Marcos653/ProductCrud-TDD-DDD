package com.example.productsapi.domain.service;

import com.example.productsapi.application.dto.request.ProductRequest;
import com.example.productsapi.domain.model.Product;
import com.example.productsapi.domain.enums.ECategory;
import com.example.productsapi.application.mapper.ProductMapper;
import com.example.productsapi.domain.repository.IProductRepository;
import com.example.productsapi.application.dto.response.ProductResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;
import java.util.Collections;
import jakarta.persistence.EntityNotFoundException;

import static com.example.productsapi.helper.ProductHelper.*;
import static com.example.productsapi.domain.utils.Messages.PRODUCT_NOT_FOUND;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    private final long productId = 1L;
    private final long nonexistentId = 100L;

    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private IProductRepository repository;
    @Mock
    private ProductMapper mapper;

    private List<Product> products;
    private Product product;
    private ProductResponse productResponse;
    private ProductRequest productRequest;

    @BeforeEach
    void setUp() {
        products = oneListOfProducts();
        product = oneProduct(productId, "Laptop", "High-end gaming laptop",
                new BigDecimal("1500.00"), 10, ECategory.ELECTRONICS);
        productResponse = oneProductResponse(productId, "Laptop", "High-end gaming laptop",
                new BigDecimal("1500.00"), 10, ECategory.ELECTRONICS.getDisplayName());
        productRequest = oneProductRequest("Laptop", "High-end gaming laptop",
                new BigDecimal("1500.00"), 10, ECategory.ELECTRONICS);
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
        when(repository.findById(productId))
                .thenReturn(Optional.of(product));
        when(mapper.toProductResponse(product))
                .thenReturn(productResponse);

        var result = productService.getById(productId);

        assertThat(result)
                .isInstanceOf(ProductResponse.class)
                .isNotNull();

        verify(repository).findById(productId);
        verify(mapper).toProductResponse(product);
    }

    @Test
    void getById_shouldThrowException_whenProductIdNotFound() {
        when(repository.findById(nonexistentId))
                .thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> productService.getById(nonexistentId))
                .withMessage(PRODUCT_NOT_FOUND + nonexistentId);

        verify(repository).findById(nonexistentId);
    }

    @Test
    void save_shouldSaveProduct_whenCalled() {
        when(repository.save(product))
                .thenReturn(product);
        when(mapper.toProduct(productRequest))
                .thenReturn(product);
        when(mapper.toProductResponse(product))
                .thenReturn(productResponse);

        var result = productService.save(productRequest);

        assertThat(result)
                .isInstanceOf(ProductResponse.class)
                .isNotNull();

        verify(mapper).toProduct(productRequest);
        verify(repository).save(product);
        verify(mapper).toProductResponse(product);
    }

    @Test
    void update_shouldUpdateProduct_whenCalled() {
        when(repository.findById(productId))
                .thenReturn(Optional.of(product));
        when(repository.save(product))
                .thenReturn(product);
        when(mapper.toProduct(productRequest))
                .thenReturn(product);
        when(mapper.toProductResponse(product))
                .thenReturn(productResponse);

        var result = productService.update(productId, productRequest);

        assertThat(result)
                .isInstanceOf(ProductResponse.class)
                .isNotNull();

        verify(repository).findById(productId);
        verify(mapper).toProduct(productRequest);
        verify(repository).save(product);
        verify(mapper).toProductResponse(product);
    }

    @Test
    void update_shouldNotUpdateProduct_whenProductIdNotFound() {
        when(repository.findById(nonexistentId))
                .thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> productService.update(nonexistentId, productRequest))
                .withMessage(PRODUCT_NOT_FOUND + nonexistentId);

        verify(repository).findById(nonexistentId);
        verifyNoInteractions(mapper);
        verify(repository, never()).save(product);
    }

    @Test
    void delete_shouldDeleteProduct_whenCalled() {
        when(repository.findById(productId))
                .thenReturn(Optional.of(product));
        doNothing().when(repository).deleteById(productId);

        assertThatCode(() -> productService.delete(productId))
                .doesNotThrowAnyException();

        verify(repository).findById(productId);
        verify(repository).deleteById(productId);
    }

    @Test
    void delete_shouldNotDeleteProduct_whenProductIdNotFound() {
        when(repository.findById(nonexistentId))
                .thenReturn(Optional.empty());

        assertThatExceptionOfType(EntityNotFoundException.class)
                .isThrownBy(() -> productService.delete(nonexistentId))
                .withMessage(PRODUCT_NOT_FOUND + nonexistentId);

        verify(repository).findById(nonexistentId);
        verify(repository, never()).deleteById(nonexistentId);
    }
}
