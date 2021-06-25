package com.kodilla.dto;

import lombok.*;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

    Long id ;
    String name;
    String description;
    BigDecimal price;
    String groupId;
}
