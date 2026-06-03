package com.agnello.catalogue.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.agnello.catalogue.services.JwtValidatorService;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final JwtValidatorService jwtValidator;

    public CatalogController(
            JwtValidatorService jwtValidator
    ) {
        this.jwtValidator = jwtValidator;
    }

    @GetMapping
    public String health() {
        return "Catalog Service Online";
    }

    @GetMapping("/wines")
    public Object wines(
            @RequestHeader("Authorization") String auth
    ) {

        String token =
                auth.replace("Bearer ", "");

        if (!jwtValidator.isValid(token)) {

            return HttpStatus.UNAUTHORIZED;
        }

        return List.of(
                "Cabernet Sauvignon",
                "Merlot",
                "Malbec",
                "Chardonnay"
        );
    }
}