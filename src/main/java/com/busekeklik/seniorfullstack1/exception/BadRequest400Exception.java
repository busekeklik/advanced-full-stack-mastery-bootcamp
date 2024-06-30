package com.busekeklik.seniorfullstack1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Catch 400 Bad request or there is no url that entered
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequest400Exception extends RuntimeException{
    public BadRequest400Exception(String message) {
        super(message);
    }
}
