package com.example.hotelrental.ui.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Создать отель")
public class CreateHotelJsonRequest {
  @Schema(description = "Название отеля", example = "Континенталь")
  private String title;
  @Schema(description = "Адрес", example = "улица Губкина, дом 10")
  private String address;
  @Schema(description = "ID города", example = "1")
  private Long cityId;
}
