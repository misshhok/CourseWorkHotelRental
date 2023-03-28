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
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotels")
@Data
public class HotelEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "rate")
  private BigDecimal rate;

  @Column(name = "address")
  private String address;

  @ManyToOne
  private CityEntity city;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "hotel_id")
  private List<RoomEntity> rooms = new ArrayList<>();
}
