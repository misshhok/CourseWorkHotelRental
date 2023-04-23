package com.example.hotelrental.infrastructure.repository;

import com.example.hotelrental.infrastructure.dao.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
    Optional<CityEntity> findByTitle(String title);
}
