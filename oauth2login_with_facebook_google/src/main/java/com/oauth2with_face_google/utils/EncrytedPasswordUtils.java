package com.oauth2with_face_google.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
    public String encrytePassword(String password){
        return  new BCryptPasswordEncoder().encode(password);
    }
}
