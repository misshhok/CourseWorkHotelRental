package com.example.hotelrental.infrastructure.service.dto.additionalfeature;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateAdditionalFeatureRequest {
  private String description;
  private BigDecimal price;
}
