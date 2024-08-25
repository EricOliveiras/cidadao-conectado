package com.cidadao.conectado.modules.user;

import com.cidadao.conectado.modules.user.payload.request.CreateUserRequest;
import com.cidadao.conectado.modules.user.payload.response.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(CreateUserRequest createUserRequest);
    UserResponse toDto(User user);
    List<UserResponse> toDto(List<User> users);
}