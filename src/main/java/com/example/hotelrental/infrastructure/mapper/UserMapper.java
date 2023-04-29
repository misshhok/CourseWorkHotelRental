package com.example.hotelrental.infrastructure.mapper;

import com.example.hotelrental.infrastructure.dao.security.User;
import com.example.hotelrental.infrastructure.service.dto.user.CreateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  User toEntity(CreateUserRequest createUserRequest);
}
