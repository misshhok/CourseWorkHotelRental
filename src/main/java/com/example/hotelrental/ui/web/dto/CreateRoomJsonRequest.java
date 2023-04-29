package com.example.hotelrental.ui.web.dto;

import java.math.BigDecimal;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Создать номер")
public class CreateRoomJsonRequest {
  @Schema(description = "Этаж", example = "1")
  private int floor;
  @Schema(description = "ID отеля", example = "1")
  private Long hotelId;
  @Schema(description = "Номер комнаты", example = "666")
  private int roomNumber;
  @Schema(description = "Цена за сутки", example = "1000")
  private BigDecimal pricePerDay;
}
