package com.example.hotelrental.infrastructure.service.dto.rent;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

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
