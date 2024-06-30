package com.busekeklik.seniorfullstack1.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

//Lombok
@RequiredArgsConstructor //Inject
@Log4j2

//API
@RestController
@CrossOrigin
//Class, Method for Spring Error
public class ErrorControllerHandleWebRequest implements ErrorController {

    //Injection
    //servlet
    private final ErrorAttributes errorAttributes;

    //http://localhost:1111/error
    @RequestMapping("/error")
    public ApiResult handleError(WebRequest webRequest){
        return null;
    }
}
