package com.example.snake.service;

import com.example.snake.model.*;
import com.example.snake.repository.ScoreRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScoreService {
    private final ScoreRepository repository;
    public ScoreService(ScoreRepository repository) { this.repository = repository; }
    public List<Score> top(int limit) { return repository.findAllByOrderByPointsDescCreatedAtAsc(PageRequest.of(0, Math.min(Math.max(limit, 1), 50))); }
    public Score save(String name, int points, Difficulty difficulty) { return repository.save(new Score(name.trim(), points, difficulty)); }
}
