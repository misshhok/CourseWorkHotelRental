package com.example.hotelrental.infrastructure.dao;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "additional_features")
public class AdditionalFeatureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "rents_additional_features", joinColumns = @JoinColumn(name = "rent_id"))
    private Set<RentEntity> rentEntities = new HashSet<>();
}
