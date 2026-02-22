package com.flabz.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Address(String firstLine, String city) {
};

record Person(String name, int age, Address address) {
};

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Salomon";
    }

    @Bean
    public int age() {
        return 20;
    }

    @Bean
    public Person person() {
        var per = new Person("Daniel", 15, new Address("Margaritones", "San Nicolas"));
        return per;
    }

    @Bean
    public Person person2MethodCall() {
        var per = new Person(name(), age(), address());// method call method in order to wire objects
        return per;
    }

    // specifies which bean to auto wire @Qualifier("adress1qualifuier") Address
    // address)
    @Bean
    public Person person3Parameters(String name, int age, @Qualifier("adress1qualifuier") Address address) {
        var per = new Person(name, age, address);// pass as parameters
        return per;
    }

    @Bean
    public Person person4Qualifier(String name, int age, Address address) {
        var per = new Person(name, age, address);// pass as parameters
        return per;
    }

    @Bean(name = "address1") // override the name of the bean name
    @Qualifier("adress1qualifuier")
    public Address address() {
        var add = new Address("Linda Vista", "Guadalupe");
        return add;
    }

    /*
     * Multiple matching beans(candidates): Spring throws an exeption
     * the solution is to make one bean primary
     */

    @Bean(name = "address2") // override the name of the bean name
    @Primary // sets priority
    public Address address2() {
        var add = new Address("Linda Vista", "Guadalupe");
        return add;
    }

}
