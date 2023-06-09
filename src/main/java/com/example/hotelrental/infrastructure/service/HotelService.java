package com.example.hotelrental.infrastructure.service;

import java.math.BigDecimal;
import java.util.List;
import com.example.hotelrental.infrastructure.dao.HotelEntity;
import com.example.hotelrental.infrastructure.service.dto.hotel.AddRateToHotelRequest;
import com.example.hotelrental.infrastructure.service.dto.hotel.CreateHotelRequest;
import com.example.hotelrental.infrastructure.service.dto.hotel.HotelDto;

public interface HotelService {
  boolean createHotel(CreateHotelRequest createHotelRequest);

  BigDecimal addRateToHotel(AddRateToHotelRequest addRateToHotelRequest);

  List<HotelDto> getAllHotels();

  HotelDto getHotelById(Long id);

  HotelEntity getHotelEntityById(Long id);

  boolean hasRoom(Long hotelId, int roomNumber);
}
