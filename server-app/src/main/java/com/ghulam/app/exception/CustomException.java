package com.ghulam.app.exception;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomException {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Map<String, String> handler(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(err -> {
            String field = ((FieldError) err).getField();
            String msg = err.getDefaultMessage();

            errors.put(field, msg);
        });

        return errors;
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public Map<String, String> handler(BadCredentialsException ex) {
        return Map.of("message", "Invalid username or password");
    }

    @ExceptionHandler(value = RuntimeException.class)
    public void any(RuntimeException ex) {
        ex.printStackTrace();
    }
}
