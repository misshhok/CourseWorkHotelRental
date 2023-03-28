package com.example.hotelrental.ui.web.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CreateAdditionalFeatureJsonRequest {
  private String description;
  private BigDecimal price;
}
