package com.busekeklik.seniorfullstack1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Catch 401 Unauthorized Entry
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class Authorized401Exception extends RuntimeException{

    public Authorized401Exception(String message) {
        super(message);
    }
}
