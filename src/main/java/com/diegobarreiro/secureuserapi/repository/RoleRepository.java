package com.diegobarreiro.secureuserapi.repository;

import com.diegobarreiro.secureuserapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
