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

    private long idUser;
    private boolean isRealized;
    private List<ProductDto> products = new ArrayList<>();
}
