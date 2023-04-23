package com.example.hotelrental.infrastructure.repository.security;

import com.example.hotelrental.infrastructure.dao.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(String name);

    void deleteByName(String name);
}
