package com.example.hotelrental.infrastructure.service;

import java.util.List;
import com.example.hotelrental.infrastructure.service.dto.role.CreateRoleRequest;
import com.example.hotelrental.infrastructure.service.dto.role.RoleDto;

public interface RoleService {
  boolean createRole(CreateRoleRequest createRoleRequest);

  boolean removeRole(Long id);

  List<RoleDto> getAllRoles();
}
