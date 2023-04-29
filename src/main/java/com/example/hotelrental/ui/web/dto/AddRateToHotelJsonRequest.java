package com.example.hotelrental.ui.web.dto;

import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Создать оценку")
public class AddRateToHotelJsonRequest {
  @Schema(description = "ID отеля", example = "1")
  private Long hotelId;
  @Schema(description = "значение оценки", example = "5")
  private BigDecimal rate;
}
