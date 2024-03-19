package com.example.productsapi.application.controller;

import com.example.productsapi.domain.service.contract.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import lombok.SneakyThrows;

import static org.assertj.core.api.Fail.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    private static final String API_URL = "/api/products";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IProductService service;

    @Test
    @SneakyThrows
    void getAll_shouldReturnStatusOk_whenCalled() {
        mockMvc.perform(get(API_URL))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void getById_shouldReturnStatusOk_whenCalled() {
        fail("not implemented");
    }
}
