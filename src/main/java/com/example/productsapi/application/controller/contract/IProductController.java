package com.example.productsapi.application.controller.contract;

import com.example.productsapi.application.dto.response.ProductResponse;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface IProductController {

    @GetMapping
    List<ProductResponse> getAll();
}
