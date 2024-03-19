package com.example.productsapi.application.controller;

import com.example.productsapi.application.dto.request.ProductRequest;
import com.example.productsapi.domain.enums.ECategory;
import com.example.productsapi.domain.service.contract.IProductService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import lombok.SneakyThrows;

import java.math.BigDecimal;

import static com.example.productsapi.helper.ProductHelper.oneProductRequest;
import static com.example.productsapi.helper.TestsHelper.convertObjectToJsonBytes;
import static org.assertj.core.api.Fail.fail;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    private static final String API_URL = "/api/products";
    private final long productId = 1L;
    private final long nonexistentId = 100L;

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IProductService service;

    private ProductRequest productRequest;

    @BeforeEach
    void setUp() {
        productRequest = oneProductRequest("Laptop", "High-end gaming laptop",
                new BigDecimal("1500.00"), 10, ECategory.ELECTRONICS);
    }

    @Test
    @SneakyThrows
    void getAll_shouldReturnStatusOk_whenCalled() {
        mockMvc.perform(get(API_URL))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void getById_shouldReturnStatusOk_whenCalled() {
        mockMvc.perform(get(API_URL + "/{id}", productId))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void getById_shouldReturnStatusNotFound_whenProductNotFound() {
        doThrow(new EntityNotFoundException())
                .when(service).getById(nonexistentId);

        mockMvc.perform(get(API_URL + "/{id}", nonexistentId))
                .andExpect(status().isNotFound());
    }

    @Test
    @SneakyThrows
    void save_shouldReturnStatusOk_whenCalled() {
        mockMvc.perform(post(API_URL)
                        .content(convertObjectToJsonBytes(productRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void update_shouldReturnStatusOk_whenCalled() {
        mockMvc.perform(put(API_URL + "/{id}", productId)
                        .content(convertObjectToJsonBytes(productRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void delete_shouldReturnStatusOk_whenCalled() {
        mockMvc.perform(delete(API_URL + "/{id}", productId))
                .andExpect(status().isOk());
    }
}
