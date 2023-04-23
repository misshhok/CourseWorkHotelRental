package com.example.hotelrental.ui.mapper;

import com.example.hotelrental.infrastructure.service.dto.additionalfeature.CreateAdditionalFeatureRequest;
import com.example.hotelrental.ui.web.dto.CreateAdditionalFeatureJsonRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdditionalFeatureJsonMapper {
    AdditionalFeatureJsonMapper INSTANCE = Mappers.getMapper(AdditionalFeatureJsonMapper.class);

    CreateAdditionalFeatureRequest jsonToDto(CreateAdditionalFeatureJsonRequest request);
}
