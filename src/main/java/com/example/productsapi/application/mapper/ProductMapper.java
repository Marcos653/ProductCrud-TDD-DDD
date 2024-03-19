package com.example.productsapi.application.mapper;

import com.example.productsapi.application.dto.response.ProductResponse;
import com.example.productsapi.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "description", source = "product.description")
    @Mapping(target = "price", source = "product.price")
    @Mapping(target = "quantity", source = "product.quantity")
    @Mapping(target = "category", expression = "java(product.getCategory().getDisplayName())")
    ProductResponse toProductResponse(Product product);
}
