package com.busekeklik.seniorfullstack1.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

//Lombok
// @Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2


//jackson object to json
//If there is a null value in the following data, do not show it on the frontend
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {

    // Field : s e m p v c
    private int status;
    private String path;
    private String message;
    private String error;
    Map<String, String> validationErrors;

    //private Date createdDate = new Date(System.currentTimeMillis());
    private String createdDate = nowDate();

    //Constructor

    // Constructor(parameter) -> s m p
    public ApiResult(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }

    // Constructor(parameter) -> s e m p
    public ApiResult(int status, String message, String error, String path) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
    }

    private String nowDate() {
        Locale locale = new Locale("tr", "TR");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        Date date = new Date();
        return dateFormat.format(date);
    }
}