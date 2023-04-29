package com.example.hotelrental.infrastructure.repository;

import java.util.Optional;
import com.example.hotelrental.infrastructure.dao.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
  Optional<HotelEntity> findByTitle(String title);
}
