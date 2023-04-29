package com.example.hotelrental.infrastructure.service.dto.rent;

import java.time.LocalDate;
import java.util.Set;
import com.example.hotelrental.infrastructure.dao.security.User;
import lombok.Data;

@Data
public class CreateRentRequest {
  private Long roomId;
  private LocalDate departureDate;
  private LocalDate entryDate;
  private Set<Long> additionalFeatureIds;
  private User user;
}
