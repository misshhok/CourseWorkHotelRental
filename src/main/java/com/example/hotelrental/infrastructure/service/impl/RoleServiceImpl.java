package com.example.hotelrental.infrastructure.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import com.example.hotelrental.infrastructure.dao.security.Role;
import com.example.hotelrental.infrastructure.mapper.RoleMapper;
import com.example.hotelrental.infrastructure.repository.security.RoleRepository;
import com.example.hotelrental.infrastructure.service.RoleService;
import com.example.hotelrental.infrastructure.service.dto.role.CreateRoleRequest;
import com.example.hotelrental.infrastructure.service.dto.role.RoleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;
  private final RoleMapper roleMapper = RoleMapper.INSTANCE;

  public boolean saveRole(String name) {
    if (roleRepository.findRoleByName(name).isPresent()) {
      return false;
    }
    roleRepository.save(new Role(name));
    return true;
  }

  public Role loadRoleByName(String name) {
    return roleRepository
      .findRoleByName(name)
      .orElseThrow(
        () -> new IllegalArgumentException("Failed to find role with name: " + name)
      );
  }

  public boolean removeRoleByName(String name) {
    if (roleRepository.findRoleByName(name).isPresent()) {
      roleRepository.deleteByName(name);
      return true;
    } else {
      throw new IllegalArgumentException("Failed to find role with name: " + name);
    }
  }

  @Override
  public boolean createRole(final CreateRoleRequest createRoleRequest) {
    return saveRole(createRoleRequest.getName());
  }

  @Override
  public boolean removeRole(final Long id) {
    roleRepository.deleteById(id);
    return true;
  }

  @Override
  public List<RoleDto> getAllRoles() {
    return roleRepository.findAll()
      .stream()
      .map(roleMapper::toDto)
      .collect(Collectors.toList());
  }
}
