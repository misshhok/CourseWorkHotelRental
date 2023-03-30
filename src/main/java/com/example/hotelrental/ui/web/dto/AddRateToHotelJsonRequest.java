package com.example.hotelrental.ui.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(description = "Создать оценку")
public class AddRateToHotelJsonRequest {
  @Schema(description = "ID отеля", example = "1")
  private Long hotelId;
  @Schema(description = "значение оценки", example = "5")
  private BigDecimal rate;
}
