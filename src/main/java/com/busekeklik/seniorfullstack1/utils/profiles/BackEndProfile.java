package com.busekeklik.seniorfullstack1.utils.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// spring.profiles.active=frontend
// spring.profiles.active=backend
// spring.profiles.active=fullstack


@Component// Spring nesnesi olmasını sağlamak için
@Profile("backend") //application.properties
public class BackEndProfile implements IChooseProfile{
    @Override
    public String message(String name) {
        return BackEndProfile.class+" Profile: "+name;
    }
}