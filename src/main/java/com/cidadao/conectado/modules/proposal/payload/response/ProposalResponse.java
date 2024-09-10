package com.cidadao.conectado.modules.proposal.payload.response;

import com.cidadao.conectado.modules.category.CategoryEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class ProposalResponse {
    private Long id;
    private String title;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", timezone = "America/Sao_Paulo")
    private Timestamp dateSubmission;

    private CategoryEnum categoryEnum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Timestamp getDateSubmission() {
        return dateSubmission;
    }

    public void setDateSubmission(Timestamp dateSubmission) {
        this.dateSubmission = dateSubmission;
    }

    public CategoryEnum getCategory() {
        return categoryEnum;
    }

    public void setCategory(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }
}
