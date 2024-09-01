package com.cidadao.conectado.modules.user.payload.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateUserRequest {
    @Valid

    @NotBlank(message = "O nome não pode estar vazio")
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
