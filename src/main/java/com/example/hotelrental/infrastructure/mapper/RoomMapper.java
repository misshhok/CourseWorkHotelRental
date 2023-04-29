package com.example.hotelrental.infrastructure.mapper;

import com.example.hotelrental.infrastructure.dao.RoomEntity;
import com.example.hotelrental.infrastructure.service.dto.room.RoomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomMapper {
  RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

  @Mapping(target = "hotelId", expression = "java(entity.getHotel().getId())")
  RoomDto toDto(RoomEntity entity);
}
