package com.busekeklik.seniorfullstack1.exception;

/*
100–199 (Info Codes)
200–299 (Success Codes)
300–399 (Referral Codes)
400–499 (Client Codes)
500–599 (Server Codes)
* */

public class BuseKeklikException extends RuntimeException{

    public BuseKeklikException(String message) {
        super(message);
    }
}
