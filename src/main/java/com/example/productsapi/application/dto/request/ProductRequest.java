package com.example.productsapi.application.dto.request;

import com.example.productsapi.domain.enums.ECategory;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

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
