package com.example.hotelrental.infrastructure.dao;

import com.example.hotelrental.infrastructure.dao.security.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "rents")
public class RentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "room_id")
  private RoomEntity room;

  @Column(name = "total_price")
  private BigDecimal totalPrice;

  @Column(name = "departure_date")
  private LocalDate departureDate;

  @Column(name = "entry_date")
  private LocalDate entryDate;

  @Column(name = "state")
  private boolean state = true;

  @ManyToMany(fetch = FetchType.EAGER)
  private Set<AdditionalFeatureEntity> additionalFeaturesEntities;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
