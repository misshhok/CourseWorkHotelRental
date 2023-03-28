package com.example.hotelrental.ui.web.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CreateRoomJsonRequest {
  private int floor;
  private Long hotelId;
  private int roomNumber;
  private BigDecimal pricePerDay;
}
