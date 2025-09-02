package com.diegobarreiro.secureuserapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    
    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser() {
        // Endpoint protegido que requiere autenticación
        return ResponseEntity.ok(Map.of(
            "username", "user_demo",
            "email", "demo@example.com"
        ));
    }
}