package com.example.hotelrental.infrastructure.service.dto.user;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CreateUserRequest {
  private String username;
  private String password;
  private String name;
  private String surname;
  private LocalDate dateOfBirth;
}
