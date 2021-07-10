package com.kodilla.ecommercee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Could not find user in the database")
public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("Could not find user in the database");
    }
}
