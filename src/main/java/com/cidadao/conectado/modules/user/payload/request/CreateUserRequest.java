package com.cidadao.conectado.modules.user.payload.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateUserRequest {
    @Valid

    @NotBlank(message = "O nome não pode estar vazio")
    @NotNull
    private String name;
    @NotBlank(message = "O email não pode estar vazio")
    @NotNull
    @Email(message = "Email deve ser válido")
    private String email;
    @NotNull
    @NotBlank(message = "A senha não pode estar vazia")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
