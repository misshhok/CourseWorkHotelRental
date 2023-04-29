package com.example.hotelrental.ui.mapper;

import com.example.hotelrental.infrastructure.service.dto.hotel.AddRateToHotelRequest;
import com.example.hotelrental.infrastructure.service.dto.hotel.CreateHotelRequest;
import com.example.hotelrental.ui.web.dto.AddRateToHotelJsonRequest;
import com.example.hotelrental.ui.web.dto.CreateHotelJsonRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HotelJsonMapper {
  HotelJsonMapper INSTANCE = Mappers.getMapper(HotelJsonMapper.class);

  CreateHotelRequest jsonToDto(CreateHotelJsonRequest createHotelJsonRequest);

  AddRateToHotelRequest jsonToDto(AddRateToHotelJsonRequest addRateToHotelJsonRequest);
}
