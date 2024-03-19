package com.example.productsapi.helper;

import com.example.productsapi.application.dto.request.ProductRequest;
import com.example.productsapi.application.dto.response.ProductResponse;
import com.example.productsapi.domain.enums.ECategory;
import com.example.productsapi.domain.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductHelper {

    public static Product oneProduct(Long id, String name, String description, BigDecimal price,
                                     Integer quantity, ECategory category) {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategory(category);
        return product;
    }

    public static ProductResponse oneProductResponse(Long id, String name, String description,
                                                     BigDecimal price, Integer quantity, String category) {
        return new ProductResponse(id, name, description, price, quantity, category);
    }

    public static ProductRequest oneProductRequest(String name, String description, BigDecimal price,
                                                    Integer quantity, ECategory category) {
        return new ProductRequest(name, description, price, quantity, category);
    }

    public static List<Product> oneListOfProducts() {
        return List.of(
                oneProduct(1L, "Laptop", "High-end gaming laptop",
                        new BigDecimal("1500.00"), 10, ECategory.ELECTRONICS),
                oneProduct(2L, "T-Shirt", "Cotton unisex T-shirt",
                        new BigDecimal("29.99"), 50, ECategory.CLOTHING)
        );
    }

    public static List<ProductResponse> oneListOfProductResponses() {
        return List.of(
                oneProductResponse(1L, "Laptop", "High-end gaming laptop",
                        new BigDecimal("1500.00"), 10, "Electronics"),
                oneProductResponse(2L, "T-Shirt", "Cotton unisex T-shirt",
                        new BigDecimal("29.99"), 50, "Clothing")
        );
    }
}
