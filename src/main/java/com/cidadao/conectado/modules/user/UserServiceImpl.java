package com.cidadao.conectado.modules.user;

import com.cidadao.conectado.config.error.CustomException;
import com.cidadao.conectado.modules.user.payload.request.CreateUserRequest;
import com.cidadao.conectado.modules.user.payload.request.UpdateUserRequest;
import com.cidadao.conectado.modules.user.payload.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse create(CreateUserRequest userRequest) {
        User user = userMapper.toEntity(userRequest);
        checkIfUserAlreadyExist(userRequest.getEmail());
        String hashedPassword = passwordEncoder.encode(userRequest.getPassword());
        user.setPassword(hashedPassword);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserResponse read(Long id) {
        return userMapper.toDto(readUserById(id));
    }

    @Override
    public List<UserResponse> readAll() {
        Page<User> users = userRepository.findAll(
                PageRequest.of(0, 20, Sort.by("id"))
        );
        return users
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse update(Long id, UpdateUserRequest userRequest) {
        User user = readUserById(id);
        BeanUtils.copyProperties(userRequest, user, "id");
        return userMapper.toDto(userRepository.save(user));
    }

    private User readUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(
                        () -> new CustomException("user not found", HttpStatus.NOT_FOUND)
                );
    }

    private void checkIfUserAlreadyExist(String email) {
        User user = userRepository.getUserByEmail(email);
        if (user != null) {
            throw new CustomException("client already registered.", HttpStatus.CONFLICT);
        }
    }
}
