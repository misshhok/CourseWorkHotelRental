package com.example.hotelrental.infrastructure.service;

import java.util.List;
import com.example.hotelrental.infrastructure.dao.RentEntity;
import com.example.hotelrental.infrastructure.service.dto.rent.CreateRentRequest;
import com.example.hotelrental.infrastructure.service.dto.rent.RentDto;

public interface RentService {
  boolean rentRoom(CreateRentRequest createRentRequest);

  boolean isRentExpired(Long rentId);

  boolean idRentExpired(RentEntity rent);

  boolean cancelRent(Long id);

  boolean cancelAllExpiredTasks();

  RentDto getRentDtoById(Long id);

  List<RentDto> getAllRents();
}
