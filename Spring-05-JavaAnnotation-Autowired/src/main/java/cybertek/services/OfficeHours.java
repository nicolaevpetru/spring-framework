package cybertek.services;

import cybertek.interfaces.ExtraSessions;

public class OfficeHours implements ExtraSessions {
    @Override
    public int getHours() {
        return 4;
    }
}
