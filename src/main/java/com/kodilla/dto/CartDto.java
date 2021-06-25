package com.kodilla.dto;
import lombok.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDto {

    UserDto user;
    List<ProductDto> shoppingCart = new ArrayList<>();


}
