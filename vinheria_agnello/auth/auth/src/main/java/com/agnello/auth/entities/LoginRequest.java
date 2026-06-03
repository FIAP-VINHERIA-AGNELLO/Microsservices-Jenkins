package com.agnello.auth.entities;

public record LoginRequest(
        String username,
        String password
) {
}
