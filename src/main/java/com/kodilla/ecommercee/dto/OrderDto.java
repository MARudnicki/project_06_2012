package com.kodilla.ecommercee.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {

    private Long id;
    private long userId;
    private boolean realised;
    private List<String> products = new ArrayList<>();

    public OrderDto(long userId, boolean realised, List<String> products) {
        this.userId = userId;
        this.realised = realised;
        this.products = products;
    }
}

