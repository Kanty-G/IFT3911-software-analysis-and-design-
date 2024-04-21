package TravelBookingSystem.Infrastructure;

import java.util.Enumeration;

public interface HarborDatabase
{
    void addHarbor(Harbor harbor);
    Harbor removeHarbor(String id);
    Harbor getHarbor(String id);
    Enumeration<Harbor> getAllHarbors();
}
