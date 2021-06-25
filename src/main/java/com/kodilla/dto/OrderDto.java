package com.kodilla.dto;

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
    private UserDto user;
    private ProductDto product;
    private boolean isRealized;

    public List<OrderDto> getOrder() { return new ArrayList<>(); }
}
