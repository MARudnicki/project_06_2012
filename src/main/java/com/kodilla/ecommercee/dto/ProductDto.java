package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long groupId;

    public ProductDto(String name, String description, BigDecimal price, Long groupId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
    }
}