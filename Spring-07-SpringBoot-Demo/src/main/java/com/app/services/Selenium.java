package com.app.services;

import com.app.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {
    @Override
    public int getTeachingHours() {
        return 25;
    }
}
