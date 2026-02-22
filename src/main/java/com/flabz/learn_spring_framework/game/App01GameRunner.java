package com.flabz.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App01GameRunner {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(GameConfiguration.class)) {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}