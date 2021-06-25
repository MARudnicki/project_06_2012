package com.kodilla.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class UserDto {
    private final Long id;
    private final String username;
    private final String status;
    private final Long userKey;
}
