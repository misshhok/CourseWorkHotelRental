package com.example.hotelrental.infrastructure.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
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
