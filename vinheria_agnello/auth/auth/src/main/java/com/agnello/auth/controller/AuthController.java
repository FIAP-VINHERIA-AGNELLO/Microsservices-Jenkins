package com.agnello.auth.controller;

import org.springframework.web.bind.annotation.*;

import com.agnello.auth.entities.LoginRequest;
import com.agnello.auth.services.JwtService;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping
    public String health() {
        return "Auth Service Online";
    }

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestBody LoginRequest request
    ) {

        String token =
                jwtService.generateToken(request.username());

        return Map.of("token", token);
    }
}