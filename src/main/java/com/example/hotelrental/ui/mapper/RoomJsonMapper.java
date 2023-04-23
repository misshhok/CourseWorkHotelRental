package com.example.hotelrental.ui.mapper;

import com.example.hotelrental.infrastructure.service.dto.room.CreateRoomRequest;
import com.example.hotelrental.ui.web.dto.CreateRoomJsonRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomJsonMapper {
    RoomJsonMapper INSTANCE = Mappers.getMapper(RoomJsonMapper.class);

    CreateRoomRequest jsonToDto(CreateRoomJsonRequest createRoomJsonRequest);
}
