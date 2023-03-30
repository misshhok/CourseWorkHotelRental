package com.example.hotelrental.ui.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Schema(description = "Создать доп. услугу")
public class CreateAdditionalFeatureJsonRequest {
  @Schema(description = "Описание", example = "Завтрак по утрам")
  private String description;
  @Schema(description = "Цена", example = "1000")
  private BigDecimal price;
}
