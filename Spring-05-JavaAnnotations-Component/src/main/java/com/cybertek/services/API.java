package com.ticketing.services;

import com.ticketing.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class API implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : 7");
    }
}
