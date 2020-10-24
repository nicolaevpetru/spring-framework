package com.cybertek;

import com.cybertek.configs.AppConfig;
import com.cybertek.interfaces.Course;
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
