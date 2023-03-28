package com.example.hotelrental.ui.web.controller;

import com.example.hotelrental.infrastructure.service.RoomService;
import com.example.hotelrental.infrastructure.service.dto.room.RoomDto;
import com.example.hotelrental.ui.mapper.RoomJsonMapper;
import com.example.hotelrental.ui.web.dto.CreateRoomJsonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/rooms/")
public class RoomController {
  private final RoomService roomService;
  private final RoomJsonMapper roomJsonMapper = RoomJsonMapper.INSTANCE;

  @PostMapping
  public ResponseEntity<Boolean> createRoom(@RequestBody CreateRoomJsonRequest createRoomJsonRequest) {
    return ResponseEntity.ok().body(
      roomService.createRoom(
        roomJsonMapper.jsonToDto(createRoomJsonRequest)
      )
    );
  }

  @GetMapping("{id}/")
  public ResponseEntity<RoomDto> getRoomByRoomId(@PathVariable Long id) {
    return ResponseEntity.ok().body(roomService.getRoomById(id));
  }

  @GetMapping("hotels/{id}/")
  public ResponseEntity<List<RoomDto>> getRoomsByHotelId(@PathVariable Long id) {
    return ResponseEntity.ok().body(roomService.getRoomsByHotelId(id));
  }

  @GetMapping("{id}/available/")
  public ResponseEntity<Boolean> isRoomAvailable(@PathVariable Long id) {
    return ResponseEntity.ok().body(roomService.isRoomAvailable(id));
  }

  @PutMapping("{id}/")
  public ResponseEntity<Boolean> changeRoomState(@PathVariable Long id) {
    return ResponseEntity.ok().body(roomService.changeRoomState(id));
  }
}
