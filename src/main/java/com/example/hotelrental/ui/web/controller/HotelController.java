package com.example.hotelrental.ui.web.controller;

import java.math.BigDecimal;
import java.util.List;
import com.example.hotelrental.infrastructure.service.HotelService;
import com.example.hotelrental.infrastructure.service.dto.hotel.HotelDto;
import com.example.hotelrental.ui.mapper.HotelJsonMapper;
import com.example.hotelrental.ui.web.dto.AddRateToHotelJsonRequest;
import com.example.hotelrental.ui.web.dto.CreateHotelJsonRequest;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Hotel", description = "API для работы с отелями")
public class HotelController {
  private final HotelService hotelService;
  private final HotelJsonMapper hotelJsonMapper = HotelJsonMapper.INSTANCE;

  @Operation(summary = "Создать отель", tags = "Hotel")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "true - отель создан, false - ошибка",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class))
        })
    })
  @PostMapping("admin/hotels/")
  public ResponseEntity<Boolean> createHotel(CreateHotelJsonRequest createHotelJsonRequest) {
    return ResponseEntity.ok().body(
      hotelService.createHotel(
        hotelJsonMapper.jsonToDto(createHotelJsonRequest)
      )
    );
  }

  @Operation(summary = "Создать оценку для отеля", tags = "Hotel")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Новая оценка отеля",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = BigDecimal.class))
        })
    })
  @PutMapping("hotels/")
  public ResponseEntity<BigDecimal> addRateToHotel(AddRateToHotelJsonRequest addRateToHotelJsonRequest) {
    return ResponseEntity.ok().body(
      hotelService.addRateToHotel(
        hotelJsonMapper.jsonToDto(addRateToHotelJsonRequest)
      )
    );
  }

  @Operation(summary = "Получить список отелей", tags = "Hotel")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Получен список отелей",
        content = {
          @Content(
            mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = HotelDto.class)))
        })
    })
  @GetMapping("hotels/")
  public ResponseEntity<List<HotelDto>> getAllHotels() {
    return ResponseEntity.ok().body(hotelService.getAllHotels());
  }

  @Operation(summary = "Получить информацию об отеле", tags = "Hotel")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Получена информация об отеле",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = HotelDto.class))
        })
    })
  @GetMapping("hotels/{id}/")
  public ResponseEntity<HotelDto> getHotelById(@PathVariable Long id) {
    return ResponseEntity.ok().body(hotelService.getHotelById(id));
  }
}
