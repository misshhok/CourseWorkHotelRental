package com.example.hotelrental.infrastructure.service.dto.hotel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class HotelDto {
  private Long id;
  private String title;
  private BigDecimal rate;
  private String address;
  private Long cityId;
  private List<Long> roomIds = new ArrayList<>();
}
