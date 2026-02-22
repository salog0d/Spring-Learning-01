package com.flabz.learn_spring_framework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {

        // 1: Launch a spring context
        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            // 2: Configure what we want spring to manage - @Configuration
            System.out.println(context.getBean("name"));// spring is managing name object for us
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean(Address.class)); // You can use the type of the Bean to retrieve it
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);// list all Beans managed by
                                                                                         // spring
                                                                                         // framework
        }

    }
}
