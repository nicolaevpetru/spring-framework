package com.ticketing.services;

import com.ticketing.interfaces.Course;
import com.ticketing.interfaces.ExtraSessions;

public class Java implements Course {

    //OfficeHours officeHours;

//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }

    ExtraSessions extraSessions;
    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : " + (20 + extraSessions.getHours()));
    }
}
