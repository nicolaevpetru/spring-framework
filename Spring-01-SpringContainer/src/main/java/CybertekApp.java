
import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {
        BeanFactory container = new ClassPathXmlApplicationContext("config.xml");
        Mentor mentor = (Mentor) container.getBean("fullTimeMentor");
        mentor.createAccount();
        mentor = (Mentor) container.getBean("partTimeMentor");
        mentor.createAccount();
    }
}
