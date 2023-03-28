package com.example.hotelrental.infrastructure.service.impl;

import com.example.hotelrental.infrastructure.dao.CityEntity;
import com.example.hotelrental.infrastructure.mapper.CityMapper;
import com.example.hotelrental.infrastructure.repository.CityRepository;
import com.example.hotelrental.infrastructure.service.CityService;
import com.example.hotelrental.infrastructure.service.dto.city.CityDto;
import com.example.hotelrental.infrastructure.service.dto.city.CreateCityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

  private final CityRepository cityRepository;
  private final CityMapper cityMapper = CityMapper.INSTANCE;

  @Override
  public boolean createCity(final CreateCityRequest createCityRequest) {
    if (cityRepository.findByTitle(createCityRequest.getTitle()).isPresent()) {
      return false;
    } else {
      CityEntity cityEntity = new CityEntity();
      cityEntity.setTitle(createCityRequest.getTitle());
      cityRepository.save(cityEntity);
      return true;
    }
  }

  @Override
  public List<CityDto> getAllCities() {
    return cityRepository.findAll()
      .stream()
      .map(cityMapper::toDto)
      .collect(Collectors.toList());
  }

  @Override
  public CityDto getCityById(final Long id) {
    return cityMapper.toDto(
      cityRepository
        .findById(id)
        .orElseThrow(
          () -> new IllegalArgumentException("Города с таким ID не существует")
        )
    );
  }
}
