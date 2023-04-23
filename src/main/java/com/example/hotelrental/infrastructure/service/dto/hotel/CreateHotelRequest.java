package com.example.hotelrental.infrastructure.service.dto.hotel;

import lombok.Data;

@Data
public class CreateHotelRequest {
    private String title;
    private String address;
    private Long cityId;
}
