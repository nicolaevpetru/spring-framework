import service.FullTimeMentor;
import service.MentorAccount;
import service.PartTimeMentor;

public class CybertekApp {
    public static void main(String[] args) {
        FullTimeMentor fullTime = new FullTimeMentor();
        PartTimeMentor partTime = new PartTimeMentor();
        MentorAccount mentor = new MentorAccount(fullTime);
        mentor.manageAccount();
        MentorAccount mentor2 = new MentorAccount(partTime);
        mentor2.manageAccount();
    }
}
