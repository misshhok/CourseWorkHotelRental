package com.example.hotelrental.ui.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdditionalFeatureJsonMapper {
  AdditionalFeatureJsonMapper INSTANCE = Mappers.getMapper(AdditionalFeatureJsonMapper.class);
}
