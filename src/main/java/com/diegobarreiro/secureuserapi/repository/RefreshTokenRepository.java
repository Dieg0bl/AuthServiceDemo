package com.diegobarreiro.secureuserapi.repository;

import com.diegobarreiro.secureuserapi.entity.RefreshToken;
import com.diegobarreiro.secureuserapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    void deleteByUser(User user);
}
