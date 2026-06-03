package com.agnello.catalogue.services;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;

@Service
public class JwtValidatorService {

    private static final String SECRET =
            "vinheriaagnellosecretkeyvinheriaagnellosecretkey";

    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    public boolean isValid(String token) {

        try {

            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}