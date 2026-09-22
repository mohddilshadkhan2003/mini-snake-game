package com.example.snake.controller;

import com.example.snake.model.*;
import com.example.snake.service.ScoreService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ScoreController {
    private final ScoreService service;
    public ScoreController(ScoreService service) { this.service = service; }

    @GetMapping("/scores") public List<Score> scores(@RequestParam(defaultValue = "10") int limit) { return service.top(limit); }
    @PostMapping("/scores") @ResponseStatus(HttpStatus.CREATED)
    public Score submit(@Valid @RequestBody ScoreRequest request) { return service.save(request.playerName(), request.score(), request.difficulty()); }
    @GetMapping("/health") public Health health() { return new Health("UP", Instant.now()); }

    public record Health(String status, Instant timestamp) {}
    public record ScoreRequest(@NotBlank @Size(max = 20) String playerName, @Min(1) @Max(1000000) int score, @NotNull Difficulty difficulty) {}
}
