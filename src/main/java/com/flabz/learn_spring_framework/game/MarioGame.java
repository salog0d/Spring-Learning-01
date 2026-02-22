package com.flabz.learn_spring_framework.game;

public class MarioGame implements GamingConsole {

    public void up() {
        System.out.println("Pressed up from Mario");
    }

    public void down() {
        System.out.println("Pressed down from Mario");
    }

    public void right() {
        System.out.println("Pressed right from Mario");
    }

    public void left() {
        System.out.println("Pressed left from Mario");
    }

}
