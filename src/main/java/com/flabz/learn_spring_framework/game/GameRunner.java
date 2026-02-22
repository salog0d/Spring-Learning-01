package com.flabz.learn_spring_framework.game;

public class GameRunner {
    private GamingConsole game;

    public GameRunner(GamingConsole _game) {
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
