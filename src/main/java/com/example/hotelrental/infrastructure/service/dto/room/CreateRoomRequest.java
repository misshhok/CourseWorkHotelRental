package com.example.hotelrental.infrastructure.service.dto.room;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateRoomRequest {
    private int floor;
    private Long hotelId;
    private int roomNumber;
    private BigDecimal pricePerDay;
}
