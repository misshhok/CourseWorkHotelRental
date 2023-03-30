package com.example.hotelrental.ui.web.controller;

import com.example.hotelrental.infrastructure.dao.security.User;
import com.example.hotelrental.infrastructure.service.RentService;
import com.example.hotelrental.infrastructure.service.dto.rent.RentDto;
import com.example.hotelrental.ui.mapper.RentJsonMapper;
import com.example.hotelrental.ui.web.dto.CreateRentJsonRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Rent", description = "API для работы с арендами")
public class RentController {
  private final RentService rentService;
  private final RentJsonMapper rentJsonMapper = RentJsonMapper.INSTANCE;

  @Operation(summary = "Арендовать номер", tags = "Rent")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "true - номер арендован, false - ошибка",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class))
        })
    })
  @PostMapping("rents/")
  public ResponseEntity<Boolean> rentRoom(@RequestBody CreateRentJsonRequest createRentJsonRequest,
                                          @AuthenticationPrincipal User user
  ) {
    return ResponseEntity.ok().body(
      rentService.rentRoom(
        rentJsonMapper.jsonToDto(createRentJsonRequest, user)
      )
    );
  }

  @Operation(summary = "Проверить статус аренды (истек срок/еще актуальна)", tags = "Rent")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "true - истекла, false - еще актуальна",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class))
        })
    })
  @GetMapping("rents/{id}/expired/")
  public ResponseEntity<Boolean> isRentExpired(@PathVariable Long id) {
    return ResponseEntity.ok().body(rentService.isRentExpired(id));
  }

  @Operation(summary = "Закрыть аренду", tags = "Rent")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "true - закрыта, false - ошибка",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class))
        })
    })
  @PutMapping("admin/rents/{id}/")
  public ResponseEntity<Boolean> cancelRent(@PathVariable Long id) {
    return ResponseEntity.ok().body(rentService.cancelRent(id));
  }

  @Operation(summary = "Получить информацию об аренде", tags = "Rent")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Получена информация об аренде",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = RentDto.class))
        })
    })
  @GetMapping("admin/rents/{id}/")
  public ResponseEntity<RentDto> getRentById(@PathVariable Long id) {
    return ResponseEntity.ok().body(rentService.getRentDtoById(id));
  }
  @Operation(summary = "Получить информацию обо всех арендах", tags = "Rent")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Получена информация об аренде",
        content = {
          @Content(
            mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = RentDto.class)))
        })
    })
  @GetMapping("admin/rents/")
  public ResponseEntity<List<RentDto>> getAllRents() {
    return ResponseEntity.ok().body(rentService.getAllRents());
  }
}
