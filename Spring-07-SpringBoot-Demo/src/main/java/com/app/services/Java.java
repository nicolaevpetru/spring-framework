package com.app.services;

import com.app.interfaces.Course;
import com.app.interfaces.ExtraSession;
import org.springframework.stereotype.Component;


@Component
public class Java implements Course {

    private ExtraSession extraSession;


    public Java(ExtraSession extraSession) {
        this.extraSession = extraSession;
    }

    @Override
    public int getTeachingHours() {
        return 10 + extraSession.extraHours();
    }
}
