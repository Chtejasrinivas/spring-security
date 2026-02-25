package com.learning.spring_security.config;

import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Setter
public class PasswordEncoder {

    private BCryptPasswordEncoder encoder;

    public void setPasswordStrength(int strength) {
        this.encoder = new BCryptPasswordEncoder(strength);
    }

    public String encode(String password) {
        return encoder.encode(password);
    }

}
