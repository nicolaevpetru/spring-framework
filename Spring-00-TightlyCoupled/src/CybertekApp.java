public class CybertekApp {
    public static void main(String[] args) {
        FullTimeMentor fulltime = new FullTimeMentor();
        PartTimeMentor partTime = new PartTimeMentor();
        Mentor mentor = new Mentor(fulltime, partTime);
        mentor.manageAccount();
    }
}
