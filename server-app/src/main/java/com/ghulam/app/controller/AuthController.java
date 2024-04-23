package com.ghulam.app.controller;

import com.ghulam.app.dtos.LoginRequest;
import com.ghulam.app.dtos.SignupRequest;
import com.ghulam.app.repository.UserRepository;
import com.ghulam.app.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("${api.endpoint.base-url}/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    public AuthController(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest dto) {
        String username = dto.username();
        String email = dto.email();

        boolean userExist = userRepository.existsByUsername(username);
        boolean emailExist = userRepository.existsByEmail(email);

        if (userExist) {
            return ResponseEntity.badRequest().body(Map.of("message", "Username is already taken."));
        } else if (emailExist) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email is already taken."));
        }

        authService.signup(dto);
        return ResponseEntity.ok(Map.of("message", "User registered successfully."));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest dto) {

        String username = dto.username();
        boolean userExist = userRepository.existsByUsername(username);

        if (!userExist) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid username or password."));
        }

        String token = authService.login(dto);
        if (token != null) {
            return ResponseEntity.ok(Map.of("username", username, "token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Invalid username or password."));
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        authService.logout();
        return ResponseEntity.ok().build();
    }

}
