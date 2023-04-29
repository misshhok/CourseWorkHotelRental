package com.example.hotelrental.infrastructure.service.dto.additionalfeature;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class AdditionalFeatureDto {
  private Long id;
  private String description;
  private BigDecimal price;
}
