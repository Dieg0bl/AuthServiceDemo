package com.diegobarreiro.secureuserapi.controller;

import com.diegobarreiro.secureuserapi.dto.LoginRequest;
import com.diegobarreiro.secureuserapi.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final JwtService jwtService;
    
    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Autenticación simplificada para demo
        String token = jwtService.generateToken(loginRequest.getUsernameOrEmail());
        return ResponseEntity.ok(Map.of("token", token));
    }
    
    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody Map<String, String> refreshRequest) {
        // Refresh simplificado para demo
        String newToken = jwtService.generateToken("user_demo");
        return ResponseEntity.ok(Map.of("token", newToken));
    }
}