package com.example.productsapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ECategory {

    ELECTRONICS("Electronics"),
    CLOTHING("Clothing"),
    GROCERIES("Groceries"),
    HOME_GOODS("Home Goods"),
    BOOKS("Books"),
    TOYS("Toys"),
    BEAUTY("Beauty"),
    SPORTS("Sports");

    private final String displayName;
}
