package com.example.hotelrental.ui.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Создать пользователя")
public class CreateUserJsonRequest {
  @Schema(description = "Логин", example = "user")
  private String username;
  @Schema(description = "Пароль", example = "user")
  private String password;
  @Schema(description = "Имя", example = "Иван")
  private String name;
  @Schema(description = "Фамилия", example = "Иванов")
  private String surname;
  @Schema(description = "Дата рождения", example = "2000-10-10")
  private String dateOfBirth;
}
