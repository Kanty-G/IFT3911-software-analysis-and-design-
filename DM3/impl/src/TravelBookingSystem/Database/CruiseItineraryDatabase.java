package TravelBookingSystem.Database;

import TravelBookingSystem.Default.CruiseItinerary;

import java.util.Enumeration;

public interface CruiseItineraryDatabase
{
    void AddCruiseItinerary(CruiseItinerary itinerary);
    void SetCruiseItinerary(CruiseItinerary itinerary);
    CruiseItinerary RemoveCruiseItinerary(String id);
    CruiseItinerary GetCruiseItinerary(String id);
    Enumeration<CruiseItinerary> GetAllCruiseItineraries();
}
