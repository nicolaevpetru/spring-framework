package cybertek.services;


import cybertek.interfaces.Course;
import cybertek.interfaces.ExtraSessions;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@AllArgsConstructor
public class Java implements Course {

    // Field Injection
    @Autowired
    private ExtraSessions extraSessions;

/*

    // Constructor Injection
    @Autowired
    public Java(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

*/


/*

    // Setter Injection
    @Autowired
    public void setOfficeHours(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

*/

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + (30 + extraSessions.getHours()));
    }
}
