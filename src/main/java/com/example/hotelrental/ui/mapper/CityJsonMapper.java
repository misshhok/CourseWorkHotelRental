package com.example.hotelrental.ui.mapper;

import com.example.hotelrental.infrastructure.dao.CityEntity;
import com.example.hotelrental.infrastructure.service.dto.city.CityDto;
import com.example.hotelrental.infrastructure.service.dto.city.CreateCityRequest;
import com.example.hotelrental.ui.web.dto.CreateCityJsonRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityJsonMapper {
  CityJsonMapper INSTANCE = Mappers.getMapper(CityJsonMapper.class);

  CreateCityRequest jsonToDto(CreateCityJsonRequest request);
}
