package com.example.hotelrental.infrastructure.service;

import com.example.hotelrental.infrastructure.service.dto.additionalfeature.AdditionalFeatureDto;
import com.example.hotelrental.infrastructure.service.dto.additionalfeature.CreateAdditionalFeatureRequest;

import java.util.List;

public interface AdditionalFeatureService {
    boolean createAdditionalFeature(CreateAdditionalFeatureRequest createAdditionalFeatureRequest);

    AdditionalFeatureDto getAdditionalFeatureId(Long id);

    List<AdditionalFeatureDto> getAllAdditionalFeatures();
}
