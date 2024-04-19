package TravelBookingSystem.Travel;

import java.util.Enumeration;

public interface CruiseItineraryDatabase
{
    void addCruiseItinerary(CruiseItinerary itinerary);
    void setCruiseItinerary(CruiseItinerary itinerary);
    CruiseItinerary removeCruiseItinerary(String id);
    CruiseItinerary getCruiseItinerary(String id);
    Enumeration<CruiseItinerary> getAllCruiseItineraries();
}
