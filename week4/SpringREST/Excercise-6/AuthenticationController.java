package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.*;

@RestController
@RequestMapping
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Value("${jwt.secret}")
    private String jwtSecret;

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start Authentication");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String user = extractUserFromBasicAuth(authHeader);
        String token = generateJwt(user);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        LOGGER.info("End Authentication");
        return response;
    }

    @GetMapping("/test")
    public String test() {
        return "Controller is working";
    }

    private String extractUserFromBasicAuth(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new IllegalArgumentException("Invalid Authorization header");
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        String decoded = new String(Base64.getDecoder().decode(base64Credentials));
        LOGGER.debug("Decoded credentials: {}", decoded);

        return decoded.split(":")[0]; // Extract username
    }

    private String generateJwt(String user) {
        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        return Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000)) // 20 mins
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
