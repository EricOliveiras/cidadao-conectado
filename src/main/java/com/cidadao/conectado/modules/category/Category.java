package com.cidadao.conectado.modules.category;

import com.cidadao.conectado.modules.proposal.Proposal;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy = "categories")
    private List<Proposal> proposals = new ArrayList<>();

    public Category() {
    }

    public Category(Long id, String name, List<Proposal> proposals) {
        this.id = id;
        this.name = name;
        this.proposals = proposals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Proposal> getProposals() {
        return proposals;
    }

    public void setProposals(List<Proposal> proposals) {
        this.proposals = proposals;
    }
}
