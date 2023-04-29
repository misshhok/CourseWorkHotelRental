package com.example.hotelrental.infrastructure.service.dto.room;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateRoomRequest {
  private int floor;
  private Long hotelId;
  private int roomNumber;
  private BigDecimal pricePerDay;
}
