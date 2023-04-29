package com.example.hotelrental.infrastructure.service.dto.rent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

@Data
public class RentDto {
  private Long id;
  private Long roomId;
  private BigDecimal totalPrice;
  private LocalDate departureDate;
  private LocalDate entryDate;
  private Set<Long> additionalFeatureIds;
  private Long userId;
}
