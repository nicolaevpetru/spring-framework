package cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;

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
