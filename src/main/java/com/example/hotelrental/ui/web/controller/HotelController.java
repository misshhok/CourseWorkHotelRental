package com.example.hotelrental.ui.web.controller;

import com.example.hotelrental.infrastructure.service.HotelService;
import com.example.hotelrental.infrastructure.service.dto.hotel.HotelDto;
import com.example.hotelrental.ui.mapper.HotelJsonMapper;
import com.example.hotelrental.ui.web.dto.AddRateToHotelJsonRequest;
import com.example.hotelrental.ui.web.dto.CreateHotelJsonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/hotels/")
public class HotelController {
  private final HotelService hotelService;
  private final HotelJsonMapper hotelJsonMapper = HotelJsonMapper.INSTANCE;

  @PostMapping
  public ResponseEntity<Boolean> createHotel(CreateHotelJsonRequest createHotelJsonRequest) {
    return ResponseEntity.ok().body(
      hotelService.createHotel(
        hotelJsonMapper.jsonToDto(createHotelJsonRequest)
      )
    );
  }

  @PutMapping
  public ResponseEntity<BigDecimal> addRateToHotel(AddRateToHotelJsonRequest addRateToHotelJsonRequest) {
    return ResponseEntity.ok().body(
      hotelService.addRateToHotel(
        hotelJsonMapper.jsonToDto(addRateToHotelJsonRequest)
      )
    );
  }

  @GetMapping
  public ResponseEntity<List<HotelDto>> getAllHotels() {
    return ResponseEntity.ok().body(hotelService.getAllHotels());
  }

  @GetMapping("{id}/")
  public ResponseEntity<HotelDto> getHotelById(@PathVariable Long id) {
    return ResponseEntity.ok().body(hotelService.getHotelById(id));
  }
}
