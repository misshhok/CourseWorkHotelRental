package com.example.hotelrental.infrastructure.mapper;

import com.example.hotelrental.infrastructure.dao.AdditionalFeatureEntity;
import com.example.hotelrental.infrastructure.service.dto.additionalfeature.AdditionalFeatureDto;
import com.example.hotelrental.infrastructure.service.dto.additionalfeature.CreateAdditionalFeatureRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdditionalFeatureMapper {
    AdditionalFeatureMapper INSTANCE = Mappers.getMapper(AdditionalFeatureMapper.class);

    AdditionalFeatureDto toDto(AdditionalFeatureEntity entity);

    AdditionalFeatureEntity toEntity(CreateAdditionalFeatureRequest createAdditionalFeatureRequest);
}
