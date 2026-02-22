package com.flabz.learn_spring_framework;

import com.flabz.learn_spring_framework.game.GameRunner;
import com.flabz.learn_spring_framework.game.MarioGame;
import com.flabz.learn_spring_framework.game.Pacman;
import com.flabz.learn_spring_framework.game.SuperContra;

public class AppGaming01BasicJava {
    public static void main(String[] args) {
        var marioGame = new MarioGame(); // var variable: simplifies code, lets the
        // compiler infer the type based on the
        // value assigned
        var superContra = new SuperContra();
        var pacman = new Pacman();
        var gameRunner = new GameRunner(superContra);
        gameRunner.run();
        var gameRunner2 = new GameRunner(marioGame);
        gameRunner2.run();
        var gameRunner3 = new GameRunner(pacman);
        gameRunner3.run();
    }
}