package com.example.hotelrental.ui.web.controller;

import com.example.hotelrental.infrastructure.service.RoomService;
import com.example.hotelrental.infrastructure.service.dto.room.RoomDto;
import com.example.hotelrental.ui.mapper.RoomJsonMapper;
import com.example.hotelrental.ui.web.dto.CreateRoomJsonRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Room", description = "API для работы с номерами отелей")
public class RoomController {
  private final RoomService roomService;
  private final RoomJsonMapper roomJsonMapper = RoomJsonMapper.INSTANCE;

  @Operation(summary = "Создать новый номер", tags = "Room")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "true - создан новый номер",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class))
        })
    })
  @PostMapping("admin/rooms/")
  public ResponseEntity<Boolean> createRoom(@RequestBody CreateRoomJsonRequest createRoomJsonRequest) {
    return ResponseEntity.ok().body(
      roomService.createRoom(
        roomJsonMapper.jsonToDto(createRoomJsonRequest)
      )
    );
  }

  @Operation(summary = "Получить информацию о номере", tags = "Room")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Получена информация о номере",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = RoomDto.class))
        })
    })
  @GetMapping("rooms/{id}/")
  public ResponseEntity<RoomDto> getRoomByRoomId(@PathVariable Long id) {
    return ResponseEntity.ok().body(roomService.getRoomById(id));
  }

  @Operation(summary = "Получить список номеров", tags = "Room")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Получен список номеров",
        content = {
          @Content(
            mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = RoomDto.class)))
        })
    })
  @GetMapping("rooms/hotels/{id}/")
  public ResponseEntity<List<RoomDto>> getRoomsByHotelId(@PathVariable Long id) {
    return ResponseEntity.ok().body(roomService.getRoomsByHotelId(id));
  }

  @Operation(summary = "Получить статус конкретного номера (занят/свободен)", tags = "Room")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "true - свободен, false - занят",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class))
        })
    })
  @GetMapping("rooms/{id}/available/")
  public ResponseEntity<Boolean> isRoomAvailable(@PathVariable Long id) {
    return ResponseEntity.ok().body(roomService.isRoomAvailable(id));
  }

  @Operation(summary = "Изменить статус конкретного номера (занят/свободен)", tags = "Room")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "true - свободен, false - занят",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class))
        })
    })
  @PutMapping("admin/rooms/{id}/")
  public ResponseEntity<Boolean> changeRoomState(@PathVariable Long id) {
    return ResponseEntity.ok().body(roomService.changeRoomState(id));
  }
}
