package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class UserKeyDto {
    private final BigDecimal userKey;
    private final Long validUserKeyTime;
}