package com.ticketing;

import com.ticketing.configs.AppConfig;
import com.ticketing.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        Course course = container.getBean("java", Course.class);
        System.out.println(course.toString());
        course.getTeachingHours();
    }
}
