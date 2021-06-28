package com.kodilla.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {
    private final Long id;
    private final String username;
    private final Boolean status;
    private final UserKeyDto userKey;

    public CardDto card;
}
