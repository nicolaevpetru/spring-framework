package cybertek.services;


import cybertek.interfaces.Course;
import cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {


    //@Autowired
    //@Qualifier("officeHours")
    private ExtraSessions extraSessions;

    public Java(@Qualifier("officeHours") ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + +extraSessions.getHours());
    }
}
