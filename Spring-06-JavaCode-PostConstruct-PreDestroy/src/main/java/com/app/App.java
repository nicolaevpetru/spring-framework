package com.app;

import com.app.config.AppConfig;
import com.app.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        //* Creating a container *//
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        Course course = container.getBean("java", Course.class);
        course.getTeachingHours();
        ((AnnotationConfigApplicationContext) container).close();
    }
}
