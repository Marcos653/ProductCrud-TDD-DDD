package com.example.productsapi.application.mapper;

import com.example.productsapi.application.dto.request.ProductRequest;
import com.example.productsapi.domain.model.Product;
import com.example.productsapi.domain.enums.ECategory;
import com.example.productsapi.application.dto.response.ProductResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

import static com.example.productsapi.helper.ProductHelper.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

class ProductMapperTest {

    private final ProductMapper mapper = new ProductMapperImpl();

    private Product product;
    private ProductResponse productResponse;
    private ProductRequest productRequest;

    @BeforeEach
    void setUp() {
        product = oneProduct(1L, "Laptop", "High-end gaming laptop",
                new BigDecimal("1500.00"), 10, ECategory.ELECTRONICS);
        productResponse = oneProductResponse(1L, "Laptop", "High-end gaming laptop",
                new BigDecimal("1500.00"), 10, ECategory.ELECTRONICS.getDisplayName());
        productRequest = oneProductRequest("Laptop", "High-end gaming laptop",
                new BigDecimal("1500.00"), 10, ECategory.ELECTRONICS);
    }

    @Test
    void toProductResponse_shouldConvertToProductResponse_whenCalled() {
        assertThat(mapper.toProductResponse(product))
                .isEqualTo(productResponse);
    }

    @Test
    void toProductResponse_shouldNotConvertToProductResponse_whenProductNull() {
        assertThat(mapper.toProductResponse(null))
                .isNull();
    }

    @Test
    void toProduct_shouldConvertToProduct_whenCalled() {
        assertThat(mapper.toProduct(productRequest))
                .extracting("name", "description", "price", "quantity", "category")
                .containsExactly(product.getName(), product.getDescription(),
                        product.getPrice(), product.getQuantity(), product.getCategory());
    }
}
