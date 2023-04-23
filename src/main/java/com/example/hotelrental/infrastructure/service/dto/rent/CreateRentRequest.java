package com.example.hotelrental.infrastructure.service.dto.rent;

import com.example.hotelrental.infrastructure.dao.security.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class CreateRentRequest {
    private Long roomId;
    private LocalDate departureDate;
    private LocalDate entryDate;
    private Set<Long> additionalFeatureIds;
    private User user;
}
