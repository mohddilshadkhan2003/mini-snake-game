package com.example.snake.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "scores")
public class Score {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 20) private String playerName;
    @Column(nullable = false) private int points;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private Difficulty difficulty;
    @Column(nullable = false) private Instant createdAt;

    protected Score() {}
    public Score(String playerName, int points, Difficulty difficulty) {
        this.playerName = playerName; this.points = points; this.difficulty = difficulty; this.createdAt = Instant.now();
    }
    public Long getId() { return id; }
    public String getPlayerName() { return playerName; }
    public int getPoints() { return points; }
    public Difficulty getDifficulty() { return difficulty; }
    public Instant getCreatedAt() { return createdAt; }
}
