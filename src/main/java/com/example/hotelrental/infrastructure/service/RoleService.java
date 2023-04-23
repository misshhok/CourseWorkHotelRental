package com.example.hotelrental.infrastructure.service;

import com.example.hotelrental.infrastructure.service.dto.role.CreateRoleRequest;
import com.example.hotelrental.infrastructure.service.dto.role.RoleDto;

import java.util.List;

public interface RoleService {
    boolean createRole(CreateRoleRequest createRoleRequest);

    boolean removeRole(Long id);

    List<RoleDto> getAllRoles();
}
