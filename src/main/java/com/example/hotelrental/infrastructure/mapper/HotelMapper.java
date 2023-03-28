package com.example.hotelrental.infrastructure.mapper;

import com.example.hotelrental.infrastructure.dao.HotelEntity;
import com.example.hotelrental.infrastructure.dao.RoomEntity;
import com.example.hotelrental.infrastructure.service.dto.hotel.HotelDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface HotelMapper {
  HotelMapper INSTANCE = Mappers.getMapper(HotelMapper.class);

  @Mapping(target = "cityId", expression = "java(entity.getCity().getId())")
  @Mapping(target = "roomIds", expression = "java(convertRooms(entity.getRooms()))")
  HotelDto toDto(HotelEntity entity);


  default List<Long> convertRooms(List<RoomEntity> roomEntities) {
    List<Long> resultList = new ArrayList<>();
    roomEntities.forEach(roomEntity -> resultList.add(roomEntity.getId()));
    return resultList;
  }
}
