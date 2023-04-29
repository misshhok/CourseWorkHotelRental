package com.example.hotelrental.infrastructure.repository.security;

import java.util.Optional;
import com.example.hotelrental.infrastructure.dao.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findRoleByName(String name);

  void deleteByName(String name);
}
