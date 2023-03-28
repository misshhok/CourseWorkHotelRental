package com.example.hotelrental.infrastructure.service.impl;

import com.example.hotelrental.infrastructure.dao.HotelEntity;
import com.example.hotelrental.infrastructure.mapper.HotelMapper;
import com.example.hotelrental.infrastructure.repository.CityRepository;
import com.example.hotelrental.infrastructure.repository.HotelRepository;
import com.example.hotelrental.infrastructure.service.HotelService;
import com.example.hotelrental.infrastructure.service.dto.hotel.AddRateToHotelRequest;
import com.example.hotelrental.infrastructure.service.dto.hotel.CreateHotelRequest;
import com.example.hotelrental.infrastructure.service.dto.hotel.HotelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

  private final HotelMapper hotelMapper = HotelMapper.INSTANCE;
  private final HotelRepository hotelRepository;
  private final CityRepository cityRepository;

  @Override
  public boolean createHotel(final CreateHotelRequest createHotelRequest) {
    if (hotelRepository.findByTitle(createHotelRequest.getTitle()).isPresent()) {
      return false;
    } else {
      HotelEntity hotel = new HotelEntity();
      hotel.setAddress(createHotelRequest.getAddress());
      hotel.setTitle(createHotelRequest.getTitle());
      hotel.setCity(cityRepository.findById(createHotelRequest.getCityId())
        .orElseThrow(
          () -> new IllegalArgumentException("Города с таким ID не существует")
        )
      );

      return true;
    }
  }

  @Override
  public BigDecimal addRateToHotel(final AddRateToHotelRequest addRateToHotelRequest) {
    HotelEntity hotel =
      hotelRepository.findById(
        addRateToHotelRequest.getHotelId()
      ).orElseThrow(
        () -> new IllegalArgumentException("Отеля с таким ID не существует")
      );
    if (hotel.getRate() != null) {
      BigDecimal rateSum = hotel.getRate().add(addRateToHotelRequest.getRate());
      BigDecimal calculatedRate = rateSum.divide(BigDecimal.valueOf(2));
      hotel.setRate(calculatedRate);
      hotelRepository.save(hotel);
      return calculatedRate;
    }
    return null;
  }

  @Override
  public List<HotelDto> getAllHotels() {
    return hotelRepository.findAll()
      .stream()
      .map(hotelMapper::toDto)
      .collect(Collectors.toList());
  }

  @Override
  public HotelDto getHotelById(final Long id) {
    return hotelMapper.toDto(
      hotelRepository.findById(id)
        .orElseThrow(
          () -> new IllegalArgumentException("Отеля с таким ID не существует")
        )
    );
  }

  @Override
  public boolean hasRoom(final Long hotelId, final int roomNumber) {
    HotelEntity hotel = hotelRepository.findById(hotelId).orElseThrow(
      () -> new IllegalArgumentException("Отеля с таким ID не существует")
    );
    return hotel
      .getRooms()
      .stream()
      .anyMatch(
        room -> room.getRoomNumber() == roomNumber
      );
  }
}
