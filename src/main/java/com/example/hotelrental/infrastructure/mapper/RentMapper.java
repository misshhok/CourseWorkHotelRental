package com.example.hotelrental.infrastructure.mapper;

import com.example.hotelrental.infrastructure.dao.AdditionalFeatureEntity;
import com.example.hotelrental.infrastructure.dao.RentEntity;
import com.example.hotelrental.infrastructure.service.dto.rent.RentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.HashSet;
import java.util.Set;

@Mapper
public interface RentMapper {
  RentMapper INSTANCE = Mappers.getMapper(RentMapper.class);

  @Mapping(target = "additionalFeatureIds", expression = "java(convertFeatures(entity.getAdditionalFeaturesEntities()))")
  @Mapping(target = "roomId", expression = "java(entity.getRoom().getId())")
  @Mapping(target = "userId", expression = "java(entity.getUser().getId())")
  RentDto toDto(RentEntity entity);

  default Set<Long> convertFeatures(Set<AdditionalFeatureEntity> additionalFeatureEntities) {
    Set<Long> resultList = new HashSet<>();
    additionalFeatureEntities.forEach(roomEntity -> resultList.add(roomEntity.getId()));
    return resultList;
  }
}
