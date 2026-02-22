package com.flabz.learn_spring_framework.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

    @Bean
    public GamingConsole game() {
        var game = new Pacman();
        return game;
    }

    @Bean
    public GameRunner run() {
        GameRunner runner = new GameRunner(game());
        return runner;
    }

}
