package com.example.productsapi.application.mapper;

import com.example.productsapi.domain.model.Product;
import com.example.productsapi.domain.enums.ECategory;
import com.example.productsapi.application.dto.response.ProductResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

import static com.example.productsapi.helper.ProductHelper.oneProduct;
import static com.example.productsapi.helper.ProductHelper.oneProductResponse;
import static org.assertj.core.api.Assertions.assertThat;

class ProductMapperTest {

    private final ProductMapper mapper = new ProductMapperImpl();

    private Product product;
    private ProductResponse productResponse;

    @BeforeEach
    void setUp() {
        product = oneProduct(1L, "Laptop", "High-end gaming laptop",
                new BigDecimal("1500.00"), 10, ECategory.ELECTRONICS);
        productResponse = oneProductResponse(1L, "Laptop", "High-end gaming laptop",
                new BigDecimal("1500.00"), 10, ECategory.ELECTRONICS.getDisplayName());
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
}
