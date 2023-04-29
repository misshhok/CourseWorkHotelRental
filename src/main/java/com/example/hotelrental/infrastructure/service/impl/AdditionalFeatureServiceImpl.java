package com.example.hotelrental.infrastructure.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import com.example.hotelrental.infrastructure.dao.AdditionalFeatureEntity;
import com.example.hotelrental.infrastructure.mapper.AdditionalFeatureMapper;
import com.example.hotelrental.infrastructure.repository.AdditionalFeatureRepository;
import com.example.hotelrental.infrastructure.service.AdditionalFeatureService;
import com.example.hotelrental.infrastructure.service.dto.additionalfeature.AdditionalFeatureDto;
import com.example.hotelrental.infrastructure.service.dto.additionalfeature.CreateAdditionalFeatureRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdditionalFeatureServiceImpl implements AdditionalFeatureService {
  private final AdditionalFeatureRepository additionalFeatureRepository;
  private final AdditionalFeatureMapper additionalFeatureMapper = AdditionalFeatureMapper.INSTANCE;

  @Override
  public boolean createAdditionalFeature(final CreateAdditionalFeatureRequest createAdditionalFeatureRequest) {
    if (additionalFeatureRepository.existsByDescriptionAndPrice(
      createAdditionalFeatureRequest.getDescription(),
      createAdditionalFeatureRequest.getPrice()
    )
    ) {
      return false;
    } else {
      AdditionalFeatureEntity additionalFeature =
        additionalFeatureMapper.toEntity(createAdditionalFeatureRequest);
      additionalFeatureRepository.save(additionalFeature);
      return true;
    }
  }

  @Override
  public AdditionalFeatureDto getAdditionalFeatureId(final Long id) {
    return additionalFeatureMapper.toDto(
      additionalFeatureRepository.findById(id)
        .orElseThrow(
          () ->
            new IllegalArgumentException(
              "Дополнительной услуги с таким ID не существует"
            )
        )
    );
  }

  @Override
  public List<AdditionalFeatureDto> getAllAdditionalFeatures() {
    return additionalFeatureRepository.findAll()
      .stream()
      .map(additionalFeatureMapper::toDto)
      .collect(Collectors.toList());
  }
}
