package com.busekeklik.seniorfullstack1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Catch 404 Not Found Anything
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFound404Exception extends RuntimeException{
    public NotFound404Exception(String message) {
        super(message);
    }
}
