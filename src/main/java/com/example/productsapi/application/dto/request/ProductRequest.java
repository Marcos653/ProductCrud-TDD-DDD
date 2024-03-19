package com.example.productsapi.application.dto.request;

import com.example.productsapi.domain.enums.ECategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        BigDecimal price,
        @NotNull
        Integer quantity,
        @NotNull
        ECategory category) {
}
