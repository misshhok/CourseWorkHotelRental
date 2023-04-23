package com.example.hotelrental.infrastructure.service;

import com.example.hotelrental.infrastructure.dao.RoomEntity;
import com.example.hotelrental.infrastructure.service.dto.room.CreateRoomRequest;
import com.example.hotelrental.infrastructure.service.dto.room.RoomDto;

import java.util.List;

public interface RoomService {
    boolean createRoom(CreateRoomRequest createRoomRequest);

    RoomDto getRoomById(Long id);

    List<RoomDto> getRoomsByHotelId(Long id);

    boolean isRoomAvailable(Long roomId);

    boolean changeRoomState(Long roomId);

    RoomEntity getRoomByRoomId(Long id);
}
