package com.example.hotelrental.infrastructure.mapper;

import com.example.hotelrental.infrastructure.dao.CityEntity;
import com.example.hotelrental.infrastructure.service.dto.city.CityDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    CityDto toDto(CityEntity cityEntity);
}
