# Mini Snake Game 🐍

A polished, responsive Snake game with a neon arcade UI, built with **Java 17**, **Spring Boot**, and a modern vanilla JavaScript frontend. The game runs smoothly in the browser while the Spring REST API persists and serves the global leaderboard using an embedded H2 database.

![Java](https://img.shields.io/badge/Java-17-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4-brightgreen) ![License](https://img.shields.io/badge/license-MIT-blue)

## Features

- Responsive neon arcade interface with animated gradients and glassmorphism panels
- Classic Snake gameplay with keyboard, swipe, and on-screen controls
- Four difficulty modes with different board sizes and speeds
- Pause/resume, restart, sound toggle, dark/light theme toggle, and high-score tracking
- Bonus fruit, progressive speed, combo scoring, and particle effects
- REST API for leaderboard scores and health status
- H2 persistence with validation and sorted top-ten scores
- No frontend build tool required: Spring serves the complete static app

## Run locally

Prerequisites: Java 17+ and Maven 3.9+ (or use the Maven wrapper after adding one).

```bash
mvn spring-boot:run
```

Open <http://localhost:8080>.

To build and run the jar:

```bash
mvn clean package
java -jar target/mini-snake-game-1.0.0.jar
```

## REST API

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/scores?limit=10` | Get the highest scores |
| `POST` | `/api/scores` | Submit a score: `{ "playerName": "Alex", "score": 120, "difficulty": "HARD" }` |
| `GET` | `/api/health` | Service health check |

The H2 console is available at `/h2-console` during development. JDBC URL: `jdbc:h2:mem:snake`.

## Project structure

```text
src/main/java/com/example/snake
├── SnakeGameApplication.java
├── config/DataSeeder.java
├── controller/ScoreController.java
├── model/Difficulty.java
├── model/Score.java
├── repository/ScoreRepository.java
└── service/ScoreService.java
src/main/resources/static
├── index.html
├── styles.css
└── app.js
```

## Gameplay

Use **Arrow keys** or **WASD** to move. Press **Space** to pause. On mobile, swipe or use the directional pad. Eat red fruit, avoid the walls and your tail, and chase the leaderboard.

## License

MIT © 2026 Mohd Dilshad Khan
