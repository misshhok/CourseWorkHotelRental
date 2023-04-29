package com.example.hotelrental.infrastructure.mapper;

import com.example.hotelrental.infrastructure.dao.security.Role;
import com.example.hotelrental.infrastructure.service.dto.role.CreateRoleRequest;
import com.example.hotelrental.infrastructure.service.dto.role.RoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {
  RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

  RoleDto toDto(Role role);

  Role toEntity(CreateRoleRequest request);
}
