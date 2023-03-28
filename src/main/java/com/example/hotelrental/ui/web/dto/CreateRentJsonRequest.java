package com.example.hotelrental.ui.web.dto;

import com.example.hotelrental.infrastructure.dao.security.User;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
public class CreateRentJsonRequest {
  private Long roomId;
  private LocalDate departureDate;
  private LocalDate entryDate;
  private Set<Long> additionalFeatureIds;
  private User user;
}
