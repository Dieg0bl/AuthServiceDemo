package com.diegobarreiro.secureuserapi.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class JwtService {
    private final String jwtSecret = "jwtSecretKeyDemo"; // TODO: Cambiar por variable de entorno
    private final long jwtExpirationMs = 3600000;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // TODO: Añadir método para comprobar y leer el token JWT
    // TODO: Hacer que se puedan anular los tokens cuando el usuario cierre sesión
}
