package com.diegobarreiro.secureuserapi.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    // TODO: Hacer métodos equals y hashCode
}
