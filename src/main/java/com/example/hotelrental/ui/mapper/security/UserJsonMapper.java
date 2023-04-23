package com.example.hotelrental.ui.mapper.security;

import com.example.hotelrental.infrastructure.service.dto.user.CreateUserRequest;
import com.example.hotelrental.ui.web.dto.CreateUserJsonRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserJsonMapper {
    UserJsonMapper INSTANCE = Mappers.getMapper(UserJsonMapper.class);

    CreateUserRequest jsonToDto(CreateUserJsonRequest request);
}
