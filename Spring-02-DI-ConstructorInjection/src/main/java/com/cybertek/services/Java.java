package com.cybertek.services;

import com.cybertek.interfaces.Course;

public class Java implements Course {

    OfficeHours officeHours = new OfficeHours();

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : " + (20 + officeHours.getHours()));
    }
}
