package com.example.hotelrental.infrastructure.service.dto.additionalfeature;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AdditionalFeatureDto {
    private Long id;
    private String description;
    private BigDecimal price;
}
