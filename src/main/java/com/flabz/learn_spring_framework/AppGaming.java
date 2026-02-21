package com.flabz.learn_spring_framework;

public class AppGaming {
    public static void main(String[] args) {
        var marioGame = new MarioGame(); // var variable: simplifies code, lets the compiler infer the type based on the
                                         // value assigned
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();
    }
}