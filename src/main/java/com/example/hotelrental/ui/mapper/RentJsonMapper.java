package com.example.hotelrental.ui.mapper;

import com.example.hotelrental.infrastructure.dao.security.User;
import com.example.hotelrental.infrastructure.service.dto.hotel.AddRateToHotelRequest;
import com.example.hotelrental.infrastructure.service.dto.rent.CreateRentRequest;
import com.example.hotelrental.ui.web.dto.AddRateToHotelJsonRequest;
import com.example.hotelrental.ui.web.dto.CreateRentJsonRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentJsonMapper {
    RentJsonMapper INSTANCE = Mappers.getMapper(RentJsonMapper.class);

    @Mapping(target = "roomId", source = "request.roomId")
    @Mapping(target = "departureDate", source = "request.departureDate")
    @Mapping(target = "entryDate", source = "request.entryDate")
    @Mapping(target = "additionalFeatureIds", source = "request.additionalFeatureIds")
    @Mapping(target = "user", source = "user")
    CreateRentRequest jsonToDto(CreateRentJsonRequest request, User user);

    AddRateToHotelRequest jsonToDto(AddRateToHotelJsonRequest addRateToHotelJsonRequest);
}
