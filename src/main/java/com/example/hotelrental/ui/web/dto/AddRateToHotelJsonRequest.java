package com.example.hotelrental.ui.web.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class AddRateToHotelJsonRequest {
  private Long hotelId;
  private BigDecimal rate;
}
