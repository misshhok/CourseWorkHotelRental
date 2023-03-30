package com.example.hotelrental.ui.web.controller;

import com.example.hotelrental.infrastructure.service.CityService;
import com.example.hotelrental.infrastructure.service.dto.city.CityDto;
import com.example.hotelrental.ui.mapper.CityJsonMapper;
import com.example.hotelrental.ui.web.dto.CreateCityJsonRequest;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "City", description = "API для работы с городами")
public class CityController {
  private final CityService cityService;
  private final CityJsonMapper jsonMapper = CityJsonMapper.INSTANCE;

  @Operation(summary = "Создать город", tags = "City")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Создан новый город",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class))
        })
    })
  @PostMapping("admin/cities/")
  public ResponseEntity<Boolean> createCity(@RequestBody CreateCityJsonRequest createCityJsonRequest) {
    return ResponseEntity.ok().body(cityService.createCity(
        jsonMapper.jsonToDto(createCityJsonRequest)
      )
    );
  }

  @Operation(summary = "Получить все доступные города", tags = "City")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Получен список городов",
        content = {
          @Content(
            mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = BigDecimal.class)))
        })
    })
  @GetMapping("cities/")
  public ResponseEntity<List<CityDto>> getAllCities() {
    return ResponseEntity.ok().body(cityService.getAllCities());
  }

  @Operation(summary = "Получить город", tags = "City")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Получена информация о городе",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = BigDecimal.class))
        })
    })
  @GetMapping("cities/{id}/")
  public ResponseEntity<CityDto> getCityById(@PathVariable Long id) {
    return ResponseEntity.ok().body(cityService.getCityById(id));
  }
}
