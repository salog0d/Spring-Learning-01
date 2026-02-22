package com.flabz.learn_spring_framework.game;

public class Pacman implements GamingConsole {
    public void up() {
        System.out.println("Pressed up from Pacman");
    }

    public void down() {
        System.out.println("Pressed down from Pacman");
    }

    public void right() {
        System.out.println("Pressed right from Pacman");
    }

    public void left() {
        System.out.println("Pressed left from Pacman");
    }

}
