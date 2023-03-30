package com.example.hotelrental.ui.web.dto;

import com.example.hotelrental.infrastructure.dao.security.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
@Schema(description = "Арендовать номер")
public class CreateRentJsonRequest {
  @Schema(description = "ID номера", example = "1")
  private Long roomId;
  @Schema(description = "Дата выезда", example = "2023-12-01")
  private LocalDate departureDate;
  @Schema(description = "Дата заезда", example = "2023-12-02")
  private LocalDate entryDate;
  @Schema(description = "ID дополнительных услуг", example = "1")
  private Set<Long> additionalFeatureIds;
}
