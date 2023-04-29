package com.example.hotelrental.ui.web.controller.security;

import com.example.hotelrental.infrastructure.service.UserService;
import com.example.hotelrental.ui.mapper.security.UserJsonMapper;
import com.example.hotelrental.ui.web.dto.CreateUserJsonRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "User", description = "API для работы с пользователями")
public class UserController {
  private final UserService userService;
  private final UserJsonMapper userJsonMapper = UserJsonMapper.INSTANCE;

  @Operation(summary = "Создать пользователя", tags = "User")
  @ApiResponses(
    value = {
      @ApiResponse(
        responseCode = "200",
        description = "Создан пользователь",
        content = {
          @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class))
        })
    })
  @PostMapping("registration/")
  public ResponseEntity<Boolean> addUser(
    @RequestBody CreateUserJsonRequest createUserRequest
  ) {
    return ResponseEntity.ok().body(
      userService.registerUser(
        userJsonMapper.jsonToDto(createUserRequest)
      )
    );
  }
}