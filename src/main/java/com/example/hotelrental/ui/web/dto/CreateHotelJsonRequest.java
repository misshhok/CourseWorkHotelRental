package com.example.hotelrental.ui.web.dto;

import lombok.Data;

@Data
public class CreateHotelJsonRequest {
  private String title;
  private String address;
  private Long cityId;
}
