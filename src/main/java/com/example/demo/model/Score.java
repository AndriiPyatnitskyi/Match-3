package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(generator = "scores_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "scores_seq", sequenceName = "scores_seq", allocationSize = 1)
    @Column(name = "SCORE_ID")
    private long id;

    @Column(name = "VALUE", nullable = false)
    private int value;

    @ManyToOne
    @JoinColumn(name = "PLAYER_ID")
    @JsonBackReference
    private Player player;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

