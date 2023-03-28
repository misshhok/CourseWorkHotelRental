package com.example.hotelrental.infrastructure.service;

import com.example.hotelrental.infrastructure.service.dto.hotel.AddRateToHotelRequest;
import com.example.hotelrental.infrastructure.service.dto.hotel.CreateHotelRequest;
import com.example.hotelrental.infrastructure.service.dto.hotel.HotelDto;
import java.math.BigDecimal;
import java.util.List;

public interface HotelService {
  boolean createHotel(CreateHotelRequest createHotelRequest);

  BigDecimal addRateToHotel(AddRateToHotelRequest addRateToHotelRequest);

  List<HotelDto> getAllHotels();

  HotelDto getHotelById(Long id);

  boolean hasRoom(Long hotelId, int roomNumber);
}
