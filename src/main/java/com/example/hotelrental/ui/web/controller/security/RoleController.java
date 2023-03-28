package com.example.hotelrental.ui.web.controller.security;

import com.example.hotelrental.infrastructure.service.RoleService;
import com.example.hotelrental.infrastructure.service.dto.role.RoleDto;
import com.example.hotelrental.ui.mapper.security.RoleJsonMapper;
import com.example.hotelrental.ui.web.dto.CreateRoleJsonRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/roles")
public class RoleController {
  private final RoleService roleService;
  private final RoleJsonMapper roleJsonMapper = RoleJsonMapper.INSTANCE;

  @PostMapping
  public ResponseEntity<Boolean> createRole(@RequestBody CreateRoleJsonRequest createRoleJsonRequest) {
    return ResponseEntity.ok().body(
      roleService.createRole(
        roleJsonMapper.jsonToDto(createRoleJsonRequest)
      )
    );
  }

  @GetMapping
  public ResponseEntity<List<RoleDto>> getAllRoles() {
    return ResponseEntity.ok().body(
      roleService.getAllRoles()
    );
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Boolean> deleteRoleById(@PathVariable Long id) {
    return ResponseEntity.ok().body(
      roleService.removeRole(id)
    );
  }
}
