package com.ghulam.app.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignupRequest(

        @NotBlank(message = "Username cannot be empty.")
        String username,

        @NotBlank(message = "Email cannot be empty.")
        @Email(message = "Email should be valid.")
        String email,

        @NotBlank(message = "Password cannot be empty.")
        @Size(min = 6, message = "Password should have at least 6 characters")
        String password,
        
        String intro
) {
}
