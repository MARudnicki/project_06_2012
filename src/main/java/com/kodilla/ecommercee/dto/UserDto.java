package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private final Long id;
    private final String username;
    private final Boolean status;
    private final UserKeyDto userKey;
    private CartDto cart;
}