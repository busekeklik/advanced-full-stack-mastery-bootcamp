package com.busekeklik.seniorfullstack1.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderBean {

    public PasswordEncoder passwordEncoderMethod() {
        return new BCryptPasswordEncoder();
    }
}
