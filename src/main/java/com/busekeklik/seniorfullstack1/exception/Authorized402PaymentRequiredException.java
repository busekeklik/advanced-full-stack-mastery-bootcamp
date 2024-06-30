package com.busekeklik.seniorfullstack1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Catch 402 Payment Requirement
@ResponseStatus(value = HttpStatus.PAYMENT_REQUIRED)
public class Authorized402PaymentRequiredException extends RuntimeException{
    public Authorized402PaymentRequiredException(String message) {
        super(message);
    }
}
