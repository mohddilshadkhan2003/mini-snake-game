package com.example.snake.config;

import com.example.snake.model.*;
import com.example.snake.repository.ScoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {
    @Bean CommandLineRunner seed(ScoreRepository repository) {
        return args -> { if (repository.count() == 0) {
            repository.save(new Score("NeonNinja", 420, Difficulty.HARD));
            repository.save(new Score("PixelPilot", 280, Difficulty.NORMAL));
            repository.save(new Score("SnakeCharmer", 190, Difficulty.EASY));
        }};
    }
}
