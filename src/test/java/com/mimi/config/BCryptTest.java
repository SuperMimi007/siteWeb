package com.mimi.config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Should encoded password")
public class BCryptTest {
    @Test
    public void ShouldTestEncodePassword(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword ="Testons2022";

        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("mot de passe encodé : "+encodedPassword);
        boolean matched= passwordEncoder.matches("Testons2022",encodedPassword);
        assertTrue(matched);
    }
}
