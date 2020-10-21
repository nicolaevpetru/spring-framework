package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");
        Course course = container.getBean("java", Course.class);
        course.getTeachingHours();

//        BeanFactory countainer2 = new ClassPathXmlApplicationContext("config.xml");
//        Course course2 = countainer2.getBean("selenium", Course.class);
//        course2.getTeachingHours();
    }
}
