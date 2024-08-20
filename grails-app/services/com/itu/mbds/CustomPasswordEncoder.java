package com.itu.mbds;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomPasswordEncoder extends BCryptPasswordEncoder {

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword.startsWith("{bcrypt}")) {
            encodedPassword = encodedPassword.substring("{bcrypt}".length());
        }
        return super.matches(rawPassword, encodedPassword);
    }
}
