package com.example.hotelrental.infrastructure.repository;

import com.example.hotelrental.infrastructure.dao.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
  Optional<HotelEntity> findByTitle(String title);
}
