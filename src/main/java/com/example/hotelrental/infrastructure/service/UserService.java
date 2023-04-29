package com.example.hotelrental.infrastructure.service;

import com.example.hotelrental.infrastructure.service.dto.user.CreateUserRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  boolean registerUser(CreateUserRequest createUserRequest);

  UserDetails loadUserByUsername(String username);
}
