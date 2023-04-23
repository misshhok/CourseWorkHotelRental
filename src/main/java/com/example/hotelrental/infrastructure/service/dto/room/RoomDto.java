package com.example.hotelrental.infrastructure.service.dto.room;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomDto {
    private Long id;
    private int floor;
    private boolean state;
    private Long hotelId;
    private int roomNumber;
    private BigDecimal pricePerDay;
}
