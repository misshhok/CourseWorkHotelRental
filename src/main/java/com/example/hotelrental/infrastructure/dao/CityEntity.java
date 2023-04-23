package com.example.hotelrental.infrastructure.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cities")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private List<HotelEntity> hotels = new ArrayList<>();
}
