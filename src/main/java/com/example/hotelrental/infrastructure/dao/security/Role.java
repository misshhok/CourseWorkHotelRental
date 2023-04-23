package com.example.hotelrental.infrastructure.dao.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(final String name) {
        this.name = name;
    }

    public Role() {
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}