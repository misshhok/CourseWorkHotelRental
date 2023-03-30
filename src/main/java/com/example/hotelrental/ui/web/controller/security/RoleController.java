package com.example.hotelrental.ui.web.controller.security;

import com.example.hotelrental.infrastructure.service.RoleService;
import com.example.hotelrental.infrastructure.service.dto.role.RoleDto;
import com.example.hotelrental.ui.mapper.security.RoleJsonMapper;
import com.example.hotelrental.ui.web.dto.CreateRoleJsonRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Role", description = "API для работы с ролями пользователей")
public class RoleController {
  private final RoleService roleService;
  private final RoleJsonMapper roleJsonMapper = RoleJsonMapper.INSTANCE;
  @Operation(summary = "Создать роль", tags = "Role")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Создана роль",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class))
        })
    })
  @PostMapping
  public ResponseEntity<Boolean> createRole(@RequestBody CreateRoleJsonRequest createRoleJsonRequest) {
    return ResponseEntity.ok().body(
      roleService.createRole(
        roleJsonMapper.jsonToDto(createRoleJsonRequest)
      )
    );
  }
  @Operation(summary = "Получить список ролей", tags = "Role")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Получен список ролей",
        content = {
          @Content(
            mediaType = "application/json",
            array = @ArraySchema( schema = @Schema(implementation = RoleDto.class)))
        })
    })
  @GetMapping
  public ResponseEntity<List<RoleDto>> getAllRoles() {
    return ResponseEntity.ok().body(
      roleService.getAllRoles()
    );
  }

  @DeleteMapping("{id}/")
  public ResponseEntity<Boolean> deleteRoleById(@PathVariable Long id) {
    return ResponseEntity.ok().body(
      roleService.removeRole(id)
    );
  }
}
