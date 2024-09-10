package com.cidadao.conectado.modules.proposal;

import com.cidadao.conectado.modules.category.CategoryEnum;
import com.cidadao.conectado.modules.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private CategoryEnum categoryEnum;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @CreationTimestamp
    @Column(name = "date_submission")
    private Timestamp dateSubmission;

    public Proposal() {
    }

    public Proposal(Long id, String title, String description, CategoryEnum categoryEnum, User user, Timestamp dateSubmission) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categoryEnum = categoryEnum;
        this.user = user;
        this.dateSubmission = dateSubmission;
    }

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

    public CategoryEnum getCategory() {
        return categoryEnum;
    }

    public void setCategory(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getDateSubmission() {
        return dateSubmission;
    }

    public void setDateSubmission(Timestamp dateSubmission) {
        this.dateSubmission = dateSubmission;
    }
}
