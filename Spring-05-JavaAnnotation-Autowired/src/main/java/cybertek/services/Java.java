package cybertek.services;


import cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    private OfficeHours officeHours;


    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (30 + officeHours.getHours()));
    }
}
