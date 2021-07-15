package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class UserKeyDto {
    private final BigInteger userKey;
    private final Long validUserKeyTime;

}
