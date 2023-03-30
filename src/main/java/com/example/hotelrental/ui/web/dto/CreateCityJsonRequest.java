package com.example.hotelrental.ui.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Создать город")
public class CreateCityJsonRequest {
  @Schema(description = "Название", example = "Белгород")
  private String title;
}
