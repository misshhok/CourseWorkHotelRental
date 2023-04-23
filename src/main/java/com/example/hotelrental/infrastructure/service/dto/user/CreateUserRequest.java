package com.example.hotelrental.infrastructure.service.dto.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateUserRequest {
    private String username;
    private String password;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
}
