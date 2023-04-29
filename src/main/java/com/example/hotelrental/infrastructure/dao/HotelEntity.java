package com.example.hotelrental.infrastructure.dao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

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
