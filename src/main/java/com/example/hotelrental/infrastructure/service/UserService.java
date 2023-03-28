package com.example.hotelrental.infrastructure.service;

import com.example.hotelrental.infrastructure.service.dto.user.CreateUserRequest;

public interface UserService {
  boolean registerUser(CreateUserRequest createUserRequest);
}
