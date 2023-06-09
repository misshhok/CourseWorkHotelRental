package com.example.hotelrental.infrastructure.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import com.example.hotelrental.infrastructure.dao.RoomEntity;
import com.example.hotelrental.infrastructure.mapper.RoomMapper;
import com.example.hotelrental.infrastructure.repository.RoomRepository;
import com.example.hotelrental.infrastructure.service.HotelService;
import com.example.hotelrental.infrastructure.service.RoomService;
import com.example.hotelrental.infrastructure.service.dto.room.CreateRoomRequest;
import com.example.hotelrental.infrastructure.service.dto.room.RoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements RoomService {
  private final RoomRepository roomRepository;
  private final HotelService hotelService;
  private final RoomMapper roomMapper = RoomMapper.INSTANCE;

  @Override
  public boolean createRoom(final CreateRoomRequest createRoomRequest) {
    if (hotelService.hasRoom(createRoomRequest.getHotelId(), createRoomRequest.getRoomNumber())) {
      return false;
    } else {
      RoomEntity room = new RoomEntity();
      room.setFloor(createRoomRequest.getFloor());
      room.setHotel(hotelService.getHotelEntityById(createRoomRequest.getHotelId()));
      room.setPricePerDay(createRoomRequest.getPricePerDay());
      room.setRoomNumber(createRoomRequest.getRoomNumber());
      roomRepository.save(room);
      return true;
    }
  }

  @Override
  public RoomDto getRoomById(final Long id) {
    return roomMapper.toDto(
      roomRepository
        .findById(id)
        .orElseThrow(
          () -> new IllegalArgumentException("Номера с таким ID не существует")
        )
    );
  }

  @Override
  public List<RoomDto> getRoomsByHotelId(final Long id) {
    return roomRepository.findAll()
      .stream()
      .map(roomMapper::toDto)
      .collect(Collectors.toList());
  }

  @Override
  public boolean isRoomAvailable(final Long roomId) {
    return getRoomById(roomId).isState();
  }

  @Override
  public boolean changeRoomState(final Long roomId) {
    RoomEntity room = roomRepository
      .findById(roomId)
      .orElseThrow(
        () -> new IllegalArgumentException("Номера с таким ID не существует")
      );
    room.setState(!room.isState());
    roomRepository.save(room);
    return room.isState();
  }

  public RoomEntity getRoomByRoomId(Long id) {
    return roomRepository
      .findById(id)
      .orElseThrow(
        () -> new IllegalArgumentException("Номера с таким ID не существует")
      );
  }
}
