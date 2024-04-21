package com.ghulam.app.dtos;

public record SignupRequest(
        String username,
        String email,
        String password,
        String intro
) {
}
