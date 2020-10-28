package com.app.services;

import com.app.interfaces.ExtraSession;
import org.springframework.stereotype.Component;

@Component
public class OfficeHours implements ExtraSession {

    @Override
    public int extraHours() {
        return 8;
    }
}
