package com.example.hotelrental.ui.web.controller;

import com.example.hotelrental.infrastructure.dao.security.User;
import com.example.hotelrental.infrastructure.service.RentService;
import com.example.hotelrental.infrastructure.service.dto.rent.RentDto;
import com.example.hotelrental.ui.mapper.RentJsonMapper;
import com.example.hotelrental.ui.web.dto.CreateRentJsonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
@RequestMapping("admin/rents/")
public class RentController {
  private final RentService rentService;
  private final RentJsonMapper rentJsonMapper = RentJsonMapper.INSTANCE;

  @PostMapping
  public ResponseEntity<Boolean> rentRoom(@RequestBody CreateRentJsonRequest createRentJsonRequest,
                                          @AuthenticationPrincipal User user
  ) {
    return ResponseEntity.ok().body(
      rentService.rentRoom(
        rentJsonMapper.jsonToDto(createRentJsonRequest, user)
      )
    );
  }

  @GetMapping("{id}/expired/")
  public ResponseEntity<Boolean> isRentExpired(@PathVariable Long id) {
    return ResponseEntity.ok().body(rentService.isRentExpired(id));
  }

  @PutMapping("{id}/")
  public ResponseEntity<Boolean> cancelRent(@PathVariable Long id) {
    return ResponseEntity.ok().body(rentService.cancelRent(id));
  }

  @GetMapping("{id}/")
  public ResponseEntity<RentDto> getRentById(@PathVariable Long id) {
    return ResponseEntity.ok().body(rentService.getRentDtoById(id));
  }

  @GetMapping
  public ResponseEntity<List<RentDto>> getAllRents() {
    return ResponseEntity.ok().body(rentService.getAllRents());
  }
}
