package TravelBookingSystem.Database;

import TravelBookingSystem.Default.Harbor;

import java.util.Enumeration;

public interface HarborDatabase
{
    void AddHarbor(Harbor harbor);
    void SetHarbor(Harbor harbor);
    Harbor RemoveHarbor(String id);
    Harbor GetHarbor(String id);
    Enumeration<Harbor> GetAllHarbors();
}
