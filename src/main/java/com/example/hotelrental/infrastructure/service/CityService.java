package com.example.hotelrental.infrastructure.service;

import com.example.hotelrental.infrastructure.service.dto.city.CityDto;
import com.example.hotelrental.infrastructure.service.dto.city.CreateCityRequest;

import java.util.List;

public interface CityService {
    boolean createCity(CreateCityRequest createCityRequest);

    List<CityDto> getAllCities();

    CityDto getCityById(Long id);
}
