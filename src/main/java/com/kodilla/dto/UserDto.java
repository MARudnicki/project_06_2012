package com.kodilla.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class UserDto {
    private final Long id;
    private final String username;
    private final Boolean status;
    private final UserKeyDto userKey;

    public CardDto card;
}
