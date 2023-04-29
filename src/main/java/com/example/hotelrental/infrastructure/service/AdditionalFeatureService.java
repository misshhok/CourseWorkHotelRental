package com.example.hotelrental.infrastructure.service;

import java.util.List;
import com.example.hotelrental.infrastructure.service.dto.additionalfeature.AdditionalFeatureDto;
import com.example.hotelrental.infrastructure.service.dto.additionalfeature.CreateAdditionalFeatureRequest;

public interface AdditionalFeatureService {
  boolean createAdditionalFeature(CreateAdditionalFeatureRequest createAdditionalFeatureRequest);

  AdditionalFeatureDto getAdditionalFeatureId(Long id);

  List<AdditionalFeatureDto> getAllAdditionalFeatures();
}
