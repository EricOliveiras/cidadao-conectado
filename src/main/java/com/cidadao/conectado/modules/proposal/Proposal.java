package com.cidadao.conectado.modules.proposal;

import com.cidadao.conectado.modules.category.Category;
import com.cidadao.conectado.modules.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "proposal_category",
            joinColumns = @JoinColumn(name = "proposal_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @CreationTimestamp
    @Column(name = "date_submission")
    private Timestamp dateSubmission;

    public Proposal() {
    }

    public Proposal(Long id, String title, String description, List<Category> categories, User user, Timestamp dateSubmission) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categories = categories;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
