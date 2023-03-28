package com.example.hotelrental.infrastructure.service.dto.hotel;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class AddRateToHotelRequest {
  private Long hotelId;
  private BigDecimal rate;
}
