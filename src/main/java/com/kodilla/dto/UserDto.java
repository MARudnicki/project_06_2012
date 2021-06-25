package com.kodilla.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    Long id;
    String username;
    String status;
    BigDecimal userKey;

}
