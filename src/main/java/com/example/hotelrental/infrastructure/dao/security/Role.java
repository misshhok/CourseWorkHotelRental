package com.example.hotelrental.infrastructure.dao.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Set;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  @Transient
  @ManyToMany(mappedBy = "roles")
  private Set<User> users;

  public Role(final String name) {
    this.name = name;
  }

  public Role() {
  }

  @Override
  public String getAuthority() {
    return getName();
  }
}