package cybertek.services;


import cybertek.interfaces.Course;
import cybertek.interfaces.ExtraSessions;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Java implements Course {
    @Value("JD")
    private String batch;
    @Value("${instructor}")
    private String Instructor;
    @Value("${days}")
    private String[] days;

    @Override
    public String toString() {
        return "Java{" +
                "batch='" + batch + '\'' +
                ", Instructor='" + Instructor + '\'' +
                ", days=" + Arrays.toString(days) +
                ", extraSessions=" + extraSessions +
                '}';
    }

    private ExtraSessions extraSessions;

    public Java(@Qualifier("officeHours") ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly teaching hours : " + +extraSessions.getHours());
    }
}
