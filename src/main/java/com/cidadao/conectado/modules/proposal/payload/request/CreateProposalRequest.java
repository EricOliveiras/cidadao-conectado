package com.cidadao.conectado.modules.proposal.payload.request;

import com.cidadao.conectado.modules.category.CategoryEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateProposalRequest {
    @Valid

    @NotNull
    @NotBlank(message = "O titúlo não pode estaer vazio")
    private String title;
    @NotNull
    @NotBlank(message = "A descrição não pode estaer vazia")
    private String description;
    @NotNull(message = "O id do usuário não pode estaer vazio")
    private Long userId;
    @NotNull(message = "A categoria não pode estar vazia")
    private CategoryEnum categoryEnum;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public CategoryEnum getCategory() {
        return categoryEnum;
    }

    public void setCategory(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }
}
