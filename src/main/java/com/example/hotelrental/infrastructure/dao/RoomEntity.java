package com.example.hotelrental.infrastructure.dao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "rooms")
public class RoomEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "floor")
  private int floor;

  @Column(name = "room_number")
  private int roomNumber;

  @Column(name = "state")
  private boolean state = true;

  @Column(name = "price_per_day")
  private BigDecimal pricePerDay;

  @ManyToOne
  @JoinColumn(name = "hotel_id")
  private HotelEntity hotel;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "room_id")
  private Set<RentEntity> rentEntities = new HashSet<>();
}
