package com.challenge;

import com.challenge.calculator.Calculator;
import com.challenge.enums.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ChallengeLabApplication {

    public static void main(String[] args) throws Exception {

        ApplicationContext container = SpringApplication.run(ChallengeLabApplication.class, args);
        Calculator calculator = container.getBean("calculator", Calculator.class);
        System.out.println(calculator.getTotalCarpetCost(City.ARLINGTON));
    }
}
