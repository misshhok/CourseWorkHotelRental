package com.example.hotelrental.infrastructure.repository.security;

import com.example.hotelrental.infrastructure.dao.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
