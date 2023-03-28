package com.example.hotelrental.infrastructure.repository;

import com.example.hotelrental.infrastructure.dao.AdditionalFeatureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;

@Repository
public interface AdditionalFeatureRepository extends JpaRepository<AdditionalFeatureEntity, Long> {
  boolean existsByDescriptionAndPrice(String description, BigDecimal price);
}
