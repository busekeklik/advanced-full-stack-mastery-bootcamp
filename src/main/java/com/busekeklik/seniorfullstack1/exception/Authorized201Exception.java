package com.busekeklik.seniorfullstack1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Catch 201 Created
@ResponseStatus(value = HttpStatus.CREATED)
public class Authorized201Exception extends RuntimeException{

    public Authorized201Exception(String message) {
        super(message);
    }
}