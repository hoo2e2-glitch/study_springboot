package com.app.oauth.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class AuthCodeGenerator {

    private static final SecureRandom random = new SecureRandom();

    public static String generateAuthCode() {
        int code = random.nextInt(9999) + 10000;
        return String.valueOf(code);
    }
}
