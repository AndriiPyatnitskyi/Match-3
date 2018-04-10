package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(generator = "players_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "players_seq", sequenceName = "players_seq", allocationSize = 1)
    @Column(name = "PLAYER_ID")
    private long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "player", cascade=CascadeType.ALL)
    @JsonManagedReference
    private Set<Score> scores = new HashSet<Score>(0);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }
}
