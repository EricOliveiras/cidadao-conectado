package com.cidadao.conectado.modules.user;

import com.cidadao.conectado.modules.user.payload.request.CreateUserRequest;
import com.cidadao.conectado.modules.user.payload.request.UpdateUserRequest;
import com.cidadao.conectado.modules.user.payload.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody CreateUserRequest createUserRequest) {
        UserResponse userResponse = iUserService.create(createUserRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(iUserService.readAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(iUserService.read(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest updateUserRequest) {
        UserResponse userResponse = iUserService.update(id, updateUserRequest);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}
