package com.example.hotelrental.ui.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Создать роль")
public class CreateRoleJsonRequest {
  @Schema(description = "Название", example = "user")
  private String name;
}
