package com.example.hotelrental.ui.web.controller;

import com.example.hotelrental.infrastructure.service.CityService;
import com.example.hotelrental.infrastructure.service.dto.city.CityDto;
import com.example.hotelrental.ui.mapper.CityJsonMapper;
import com.example.hotelrental.ui.web.dto.CreateCityJsonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/cities/")
public class CityController {
  private final CityService cityService;
  private final CityJsonMapper jsonMapper = CityJsonMapper.INSTANCE;

  @PostMapping
  public ResponseEntity<Boolean> createCity(@RequestBody CreateCityJsonRequest createCityJsonRequest) {
    return ResponseEntity.ok().body(cityService.createCity(
        jsonMapper.jsonToDto(createCityJsonRequest)
      )
    );
  }

  @GetMapping
  public ResponseEntity<List<CityDto>> getAllCities() {
    return ResponseEntity.ok().body(cityService.getAllCities());
  }

  @GetMapping("{id}/")
  public ResponseEntity<CityDto> getCityById(@PathVariable Long id) {
    return ResponseEntity.ok().body(cityService.getCityById(id));
  }
}
