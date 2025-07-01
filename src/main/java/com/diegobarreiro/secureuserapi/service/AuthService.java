package com.diegobarreiro.secureuserapi.service;

import com.diegobarreiro.secureuserapi.dto.LoginRequest;
import com.diegobarreiro.secureuserapi.dto.RegisterRequest;
import com.diegobarreiro.secureuserapi.entity.User;
import com.diegobarreiro.secureuserapi.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        // TODO: Comprobar si el usuario ya existe antes de registrar
        // TODO: Poner rol por defecto al usuario nuevo
        return userRepository.save(user);
    }

    // TODO: Hacer el login y crear el token JWT
}
