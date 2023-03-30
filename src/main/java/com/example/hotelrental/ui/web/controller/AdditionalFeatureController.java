package com.example.hotelrental.ui.web.controller;

import com.example.hotelrental.infrastructure.service.AdditionalFeatureService;
import com.example.hotelrental.infrastructure.service.dto.additionalfeature.AdditionalFeatureDto;
import com.example.hotelrental.ui.mapper.AdditionalFeatureJsonMapper;
import com.example.hotelrental.ui.web.dto.CreateAdditionalFeatureJsonRequest;
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
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Additional Features", description = "API для работы с дополнительными услугами аренды")
public class AdditionalFeatureController {
  private final AdditionalFeatureService additionalFeatureService;
  private final AdditionalFeatureJsonMapper additionalFeatureJsonMapper = AdditionalFeatureJsonMapper.INSTANCE;
  @Operation(summary = "Создать дополнительную услугу аренды", tags = "Additional Features")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Создана дополнительная услуга аренды",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class))
        })
    })
  @PostMapping("admin/additional-features/")
  public ResponseEntity<Boolean> createAdditionalFeature(
    @RequestBody CreateAdditionalFeatureJsonRequest createAdditionalFeatureJsonRequest) {
    return ResponseEntity.ok().body(
      additionalFeatureService.createAdditionalFeature(
        additionalFeatureJsonMapper.jsonToDto(createAdditionalFeatureJsonRequest)
      )
    );
  }
  @Operation(summary = "Получить информацию о дополнительной услуге аренды", tags = "Additional Features")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Получена информация о дополнительной услуге аренды",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class))
        })
    })
  @GetMapping("additional-features/{id}/")
  public ResponseEntity<AdditionalFeatureDto> getAdditionalFeatureById(@PathVariable Long id) {
    return ResponseEntity.ok().body(
      additionalFeatureService.getAdditionalFeatureId(id)
    );
  }
  @Operation(summary = "Получить список дополнительных услуг аренды", tags = "Additional Features")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Получен список дополнительных услуг аренды",
        content = {
          @Content(
            mediaType = "application/json",
            array = @ArraySchema( schema = @Schema(implementation = Boolean.class)))
        })
    })
  @GetMapping("additional-features/")
  public ResponseEntity<List<AdditionalFeatureDto>> getAllAdditionalFeatures() {
    return ResponseEntity.ok().body(additionalFeatureService.getAllAdditionalFeatures());
  }
}
