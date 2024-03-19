package com.example.productsapi.application.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import lombok.SneakyThrows;

import static org.assertj.core.api.Fail.fail;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    private static final String API_URL = "/api/products";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void getAll_shouldReturnStatusOk_whenCalled() {
        fail("Not implemented");
    }
}
