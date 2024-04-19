package TravelBookingSystem.Travel;

import java.util.Enumeration;

public interface FlightDatabase
{
    void addFlight(Flight flight);
    Flight replaceFlight(Flight flight);
    Flight removeFlight(String id);
    Flight getFlight(String id);
    Enumeration<Flight> getAllFlights();
}
