package com.ghulam.app.service;

import com.ghulam.app.dtos.LoginRequest;
import com.ghulam.app.dtos.SignupRequest;
import com.ghulam.app.model.User;
import com.ghulam.app.repository.UserRepository;
import com.ghulam.app.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public AuthService(UserRepository userRepository, PasswordEncoder encoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public void signup(SignupRequest dto) {
        String username = dto.username();
        String email = dto.email();
        String password = dto.password();
        String intro = dto.intro();
        String encodedPassword = encoder.encode(password);

        User user = new User(username, email, encodedPassword, intro);
        userRepository.save(user);
    }

    public String login(LoginRequest dto) {
        String username = dto.username();
        String password = dto.password();

        Authentication auth = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticated = authenticationManager.authenticate(auth);

        return jwtService.generateToken(authenticated);
    }

    public void logout() {
        /* todo */
    }
}
