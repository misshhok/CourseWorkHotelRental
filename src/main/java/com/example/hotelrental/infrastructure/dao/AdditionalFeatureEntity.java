package com.example.hotelrental.infrastructure.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

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
