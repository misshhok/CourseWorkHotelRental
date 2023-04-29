package com.example.hotelrental.infrastructure.service;

import java.util.List;
import com.example.hotelrental.infrastructure.service.dto.city.CityDto;
import com.example.hotelrental.infrastructure.service.dto.city.CreateCityRequest;

public interface CityService {
  boolean createCity(CreateCityRequest createCityRequest);

  List<CityDto> getAllCities();

  CityDto getCityById(Long id);
}
