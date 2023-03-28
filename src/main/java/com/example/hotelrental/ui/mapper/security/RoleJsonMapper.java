package com.example.hotelrental.ui.mapper.security;

import com.example.hotelrental.infrastructure.service.dto.role.CreateRoleRequest;
import com.example.hotelrental.ui.web.dto.CreateRoleJsonRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleJsonMapper {
  RoleJsonMapper INSTANCE = Mappers.getMapper(RoleJsonMapper.class);

  CreateRoleRequest jsonToDto(CreateRoleJsonRequest createRoleJsonRequest);
}
