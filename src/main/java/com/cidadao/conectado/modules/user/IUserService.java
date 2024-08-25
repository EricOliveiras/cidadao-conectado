package com.cidadao.conectado.modules.user;

import com.cidadao.conectado.modules.user.payload.request.CreateUserRequest;
import com.cidadao.conectado.modules.user.payload.request.UpdateUserRequest;
import com.cidadao.conectado.modules.user.payload.response.UserResponse;

import java.util.List;

public interface IUserService {
    UserResponse create(CreateUserRequest userRequest);
    UserResponse read(Long id);
    List<UserResponse> readAll();
    UserResponse update(Long id, UpdateUserRequest userRequest);
}
