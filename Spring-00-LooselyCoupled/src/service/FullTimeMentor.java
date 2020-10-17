package service;

import implementation.Mentor;

public class FullTimeMentor implements Mentor {

    @Override
    public void createAccount() {
        System.out.println("Full Time mentor Account is created...");
    }
}
