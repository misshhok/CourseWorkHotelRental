package com.example.hotelrental.ui.web.dto;

import lombok.Data;

@Data
public class CreateUserJsonRequest {
  private String username;
  private String password;
  private String name;
  private String surname;
  private String dateOfBirth;
}
