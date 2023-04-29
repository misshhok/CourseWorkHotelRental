package com.example.hotelrental.infrastructure.service.dto.hotel;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class AddRateToHotelRequest {
  private Long hotelId;
  private BigDecimal rate;
}
