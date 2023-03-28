package com.example.hotelrental.ui.web.controller;

import com.example.hotelrental.infrastructure.service.AdditionalFeatureService;
import com.example.hotelrental.ui.mapper.AdditionalFeatureJsonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/additional-features/")
public class AdditionalFeatureController {
  private final AdditionalFeatureService additionalFeatureService;
  private final AdditionalFeatureJsonMapper additionalFeatureJsonMapper = AdditionalFeatureJsonMapper.INSTANCE;
}
