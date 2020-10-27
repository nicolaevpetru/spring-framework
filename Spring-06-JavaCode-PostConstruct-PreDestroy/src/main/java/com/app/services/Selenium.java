package com.app.services;

import com.app.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Teaching Hours : 25");
    }
}
