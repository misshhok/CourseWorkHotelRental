package com.example.hotelrental.infrastructure.repository;

import com.example.hotelrental.infrastructure.dao.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
}
