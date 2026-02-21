package com.flabz.learn_spring_framework;

public class GameRunner {
    MarioGame game;

    public GameRunner(MarioGame _game) {
        this.game = _game;
    }

    public void run() {
        System.out.println("Game is running: " + game);
        game.down();
        game.up();
        game.left();
        game.right();
    }
}
